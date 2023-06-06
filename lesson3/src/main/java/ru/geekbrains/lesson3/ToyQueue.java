package ru.geekbrains.lesson3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyQueue {
    private static final String FILE_PATH = "output.txt";
    private PriorityQueue<Toy> toyQueue;

    public ToyQueue(String[] toyStrings) {
        toyQueue = new PriorityQueue<>();
        for (String toyString : toyStrings) {
            String[] parts = toyString.split(" ");
            int id = Integer.parseInt(parts[0]);
            String name = parts[2];
            int weight = Integer.parseInt(parts[1]);
            Toy toy = new Toy(id, name, weight);
            toyQueue.offer(toy);
        }
    }

    public int getRandomToyId() {
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < 0.2) {
            return 1;
        } else if (rand < 0.4) {
            return 2;
        } else {
            return 3;
        }
    }

    public void writeToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (int i = 0; i < 10; i++) {
                int toyId = getRandomToyId();
                Toy toy = null;
                for (Toy t : toyQueue) {
                    if (t.getId() == toyId) {
                        toy = t;
                        break;
                    }
                }
                if (toy != null) {
                    String result = "Get: " + toy.getName();
                    writer.write(result + "\n");
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] toyStrings = {
                "1 2 конструктор",
                "2 2 робот",
                "3 6 кукла"
        };
        ToyQueue toyQueue = new ToyQueue(toyStrings);
        toyQueue.writeToFile();
    }
}

class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.weight, other.weight);
    }
}
