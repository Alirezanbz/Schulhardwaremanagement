package com.example.schulhardwaremanagement;

import com.fazecast.jSerialComm.SerialPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SerialPortReader {

    private SerialPort serialPort;
    private static final String BASE_URL = "http://localhost:8080/api/benutzer/chip/";

    public void initialize() {
        SerialPort[] ports = SerialPort.getCommPorts();
        String portName = "COM5";

        for (SerialPort port : ports) {
            if (port.getSystemPortName().equals(portName)) {
                serialPort = port;
                break;
            }
        }

        if (serialPort == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        if (serialPort.openPort()) {
            System.out.println("Port opened successfully.");
            serialPort.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0);

            Thread readThread = new Thread(this::readData);
            readThread.start();
        } else {
            System.out.println("Could not open port.");
        }
    }

    private void readData() {
        StringBuilder text = new StringBuilder();
        try {
            while (true) {
                while (serialPort.bytesAvailable() == 0) {
                    Thread.sleep(20);
                }

                byte[] readBuffer = new byte[serialPort.bytesAvailable()];
                int numRead = serialPort.readBytes(readBuffer, readBuffer.length);


                for (int i = 0; i < numRead; i++) {
                    char readChar = (char) readBuffer[i];
                    if (readChar >= ' ') {
                        text.append(readChar);
                    } else if (readChar == '\n' || readChar == '\r') {
                        if (text.length() > 0) {
                            System.out.println(text);
                            sendChipIdToServer(text.toString());
                            text.setLength(0);
                        }
                    }
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Serial reading thread interrupted: " + ex.getMessage());
        } finally {
            serialPort.closePort();
            System.out.println("Port closed.");
        }
    }

    private void sendChipIdToServer(String chipId) {
        try {
            URL url = new URL(BASE_URL + chipId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("Sending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println(response.toString());

            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error sending chip ID to server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SerialPortReader reader = new SerialPortReader();
        reader.initialize();
    }
}
