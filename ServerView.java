import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerView {
    public static void main(String[] args) throws SocketException {
        Model model = new Model();
        // CheckString check = new CheckString();
        Presenter presenter = new Presenter();
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем подключение...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (presenter.sortValue(clientRequest) == null)
                    break;
                if (clientRequest.equals("end"))
                    break;
                double a = presenter.getX(presenter.sortValue(clientRequest));
                String sign = presenter.getOper(presenter.sortValue(clientRequest));
                double b = presenter.getY(presenter.sortValue(clientRequest));
                model.setX(a);
                model.setY(b);
                model.setOperation(sign);
                double result = model.result();
                if (result % 1 > 0) {
                    dataOutputStream.writeUTF(String.format("Сумма чисел равна: %.2f", result));
                } else {
                    dataOutputStream.writeUTF(String.format("Сумма чисел равна: %.0f", result));
                }
                System.out.println("Клиент сказал " + clientRequest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}