package pl.kedrabartosz.HomeBudget;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kedrabartosz.HomeBudget.repository.ItemRepository;
import pl.kedrabartosz.HomeBudget.repository.ItemRepositoryFactory;
import pl.kedrabartosz.HomeBudget.repository.FileBasedCategoryRepository;
import pl.kedrabartosz.HomeBudget.repository.ListBasedItemRepository;
import pl.kedrabartosz.HomeBudget.service.ItemService;
import pl.kedrabartosz.HomeBudget.service.ReceiptService;

@SpringBootApplication
public class HomeBudgetApplication {


    public static void main(String[] args) {
        // SpringApplication.run(HomeBudgetApplication.class, args);
        // CostRepository costRepository = new ListBasedRepository();
        //costRepository.addCost();
        //System.out.println(costRepository.getAll());

        // 1. new
        ItemRepository itemRepository = new ListBasedItemRepository(new ArrayList<>());

        // 2. builder
        ItemRepository itemRepositoryBuilder = ListBasedItemRepository.builder().build();

        // 3. Factory
        ItemRepository itemRepositoryFactory = ItemRepositoryFactory.createCostRepository();


        // IoC - Inversion of Control, czyli nie my tworzymy obiekty tylko zlecamy to frameworkpwi
        // i to on je stworzy i wstrzyknie (w konstruktorze/setterze) wtedy gdy będa potrzebne a nie na zaś

        ConfigurableApplicationContext context = SpringApplication.run(HomeBudgetApplication.class, args);

        // context - wór ze wszystkimi beanami, którymi ma Spring zarządzać
        // aby móc korzystać z costServicu nie możemy go robić (new CostService())!!, tylko
        // pozwalamy Springowi to zrobić i my chcemy tylko się dostać do tego beana, co on stworzył,
        // i na nim operować (ale nie sami go tworzyć)
        ItemService itemService = context.getBean(ItemService.class);

        Person me = new Person("Bartosz");


        Item newItem = itemService.saveItem( "Jewelry", 250.00, Category.builder().build());
        Item newItem5 = itemService.saveItem( "Car", 4000, Category.builder().build());

        if (itemService.doesItemExits("Pencil")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        Item newItem6 = itemService.saveItem( "Pencil", 5, Category.builder().build());
        if (itemService.doesItemExits("Pencil")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        FileBasedCategoryRepository fileBasedCategoryRepository = new FileBasedCategoryRepository();
        Category buildHome = fileBasedCategoryRepository.save("budowadomu");
        Category jewelry = fileBasedCategoryRepository.save("jewelery");
        System.out.println(buildHome);
        System.out.println(fileBasedCategoryRepository.getAll());

        //shopping cart

        ReceiptService cartService = context.getBean(ReceiptService.class);



        List<Receipt> all = cartService.getShoppingCarts(me);
        System.out.println("Number cart for " + me.getName() + ": " + all.size());
        all.forEach(System.out::println);

        // @Autowired, @Service, @Component, @Repository
        // HW:  @RestController, @Bean, @Configuration,
        // HW: Scope (czym jest), primary bean*, @Value / @Resource - wstrzykiwanie po NAZWIE, by name

        // DI - Dependency Injection, wstrzykiwanie zależności (this.XXX = YYY), przypisane wartości do pola
        // Guice,
        //@Primary - Służy do wskazania preferowanego beana w przypadku, gdy jest więcej niż jeden bean tego samego typu.
        //@Value - Umożliwia wstrzykiwanie wartości (np. z plików konfiguracyjnych) do pól klasy.
        // @Resource pochodzi od javy a @Autowired od springa
        //Autowired wstrzykuje na podstawie typu a Resource na postawie nazwy


    }
}
// dokonczyc to implemetnowac interfejs Food i tez klasy gdzie beda implementowane te rzeczy! (zrobioone)
// (nazwa jedzenia resturacja czy wyjscia na jedzenie) (zrobione)
// , wstawic do gh, zapoznac sie z nowym wzorcem projektowym Repozytorium!
//poczytac pdfa!!