package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileBasedCategoryRepository implements CategoryRepository {

    private static final String CSV_PATH = "categories.csv";

    @Override
    public Category save(String name) {
        return null;
    }

    @Override
    public Optional<Category> update(String oldName, String newName) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> getCategory(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> deleteCategory(String name) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        List<Category> category = new ArrayList<>();
        BufferedReader reader = null;

        try {
            Path path = Paths.get(
                    getClass().getClassLoader()
                            .getResource(CSV_PATH)
                            .toURI()
            );
            reader = Files.newBufferedReader(path);


            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                category.add(new Category(id, name));
            }

        } catch (IOException | URISyntaxException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.err.println("Error closing reader: " + ex.getMessage());
                }
            }
        }
        return category;
    }
}
