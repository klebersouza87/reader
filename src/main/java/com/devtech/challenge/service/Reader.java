package com.devtech.challenge.service;

import com.devtech.challenge.model.Client;
import com.devtech.challenge.model.Sale;
import com.devtech.challenge.model.Salesman;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Reader {

    @Value("${home.path.input}")
    private String inputDirectory;

    @Value("${home.path.output}")
    private String outputDirectory;

    @PostConstruct
    public void read() throws IOException, InterruptedException {
        boolean valid = true;

        Path path = Paths.get(inputDirectory);
        Charset utf8 = StandardCharsets.UTF_8;

        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        do {

            WatchKey watchKey = watchService.take();
            for (WatchEvent event : watchKey.pollEvents()) {

                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();
                    Path input = Paths.get(inputDirectory + fileName);
                    System.out.println("Reading File: " + input);

                    try (BufferedReader reader = Files.newBufferedReader(input, utf8)) {
                        String line;
                        List<Salesman> salesmen = new ArrayList<>();
                        List<Client> clients = new ArrayList<>();
                        List<Sale> sales = new ArrayList<>();

                        while ((line = reader.readLine()) != null) {
                            String[] item = line.split("ç");
                            switch (item[0]) {
                                case "001":
                                    salesmen.add(new Salesman(Integer.parseInt(item[0]), item[1], item[2], Double.parseDouble(item[3])));
                                    break;
                                case "002":
                                    clients.add(new Client(Integer.parseInt(item[0]), item[1], item[2], item[3]));
                                    break;
                                case "003":
                                    sales.add(new Sale(Integer.parseInt(item[0]), Integer.parseInt(item[1]), item[2], item[3]));
                                    break;
                            }
                        }

                        String outputFilePath = outputDirectory + fileName;
                        Writer.write(salesmen, clients, sales, outputFilePath);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            valid = watchKey.reset();

        } while (valid);

    }

}
