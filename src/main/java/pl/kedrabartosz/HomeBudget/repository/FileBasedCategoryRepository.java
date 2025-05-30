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

    private static final String CSV_PATH = "categories.csv";// sciezka do pliku

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
        List<Category> categoryList = new ArrayList<>();
        BufferedReader reader = null;// buforowany czytnik do odczytu pliku linia po linii!
        // przygotowanie takiego pudelka zeby przechowywalo czytnik, jak nie zdefiniuje nulla to wywali blad!
        try {// zlokalizowanie pliku csv w classpath i konwersja na obiekt path!
            Path path = Paths.get(// na podstawie tego URI tworzymy obiekt Path ktory mowi gdzie w systemie plikow znajduje sie ten plik!
                    getClass().getClassLoader()// zwraca to plik ktory wie jak ladowac pliki i klasy z zasobow classpath
                            .getResource(CSV_PATH)// to znajduje i odczytuje plik w katalogu resources!
                            .toURI()//zamieniamy ten adres URL na obiekt typu URI, czyli ustandaryzowaną reprezentację sciezki
            );
            reader = Files.newBufferedReader(path);// otwiera to plik wskazany przez path i zwraca obiekt BufferedReader
            // i dzieki temu cala zawartosc mozna czytac linia po linii. Nie trzeba recznie tym zarzadzac!

            String line;// petla odczytujaca kolejne linie az do konca pliku!
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] tokens = line.split(",");// oddzielnie przecinkiem na kolumny id i name!
                int id = Integer.parseInt(tokens[0].trim());// parsowanie czyli konwertowanie, pierwszego tokenu na identyfiaktor typu int!
                String name = tokens[1].trim();// drugi token to nazwa kategorii!
                categoryList.add(new Category(id, name));//utworzenie obiektu category i dodanie go do listy
            }

        } catch (IOException | URISyntaxException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());// obsluga bledow wej/wyj
        } finally {
            if (reader != null) {
                try {
                    reader.close();// zamkniecie czytnika zeby zwolnic zasoby systemowe to wazne!!
                } catch (IOException ex) {
                    System.err.println("Error closing reader: " + ex.getMessage());
                }
            }
        }
        return categoryList;
    }
}
