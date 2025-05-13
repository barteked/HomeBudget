package pl.kedrabartosz.HomeBudget;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;
import pl.kedrabartosz.HomeBudget.repository.CostRepositoryFactory;
import pl.kedrabartosz.HomeBudget.repository.ListBasedCostRepository;
import pl.kedrabartosz.HomeBudget.service.CategoryService;
import pl.kedrabartosz.HomeBudget.service.CostService;

@SpringBootApplication
public class HomeBudgetApplication {


    public static void main(String[] args) {
        // SpringApplication.run(HomeBudgetApplication.class, args);
        // CostRepository costRepository = new ListBasedRepository();
        //costRepository.addCost();
        //System.out.println(costRepository.getAll());


        // 1. new
        CostRepository costRepository = new ListBasedCostRepository(new ArrayList<>());

        // 2. builder
        CostRepository costRepositoryBuilder = ListBasedCostRepository.builder().build();

        // 3. Factory
        CostRepository costRepositoryFactory = CostRepositoryFactory.createCostRepository();


        // IoC - Inversion of Control, czyli nie my tworzymy obiekty tylko zlecamy to frameworkpwi
        // i to on je stworzy i wstrzyknie (w konstruktorze/setterze) wtedy gdy będa potrzebne a nie na zaś

        ConfigurableApplicationContext context = SpringApplication.run(HomeBudgetApplication.class, args);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);

        }

        // context - wór ze wszystkimi beanami, którymi ma Spring zarządzać
        // aby móc korzystać z costServicu nie możemy go robić (new CostService())!!, tylko
        // pozwalamy Springowi to zrobić i my chcemy tylko się dostać do tego beana, co on stworzył,
        // i na nim operować (ale nie sami go tworzyć)
        CostService costService = context.getBean(CostService.class);
        Cost newCost = costService.saveCost("Jewelry", 250.00);
        System.out.println(newCost);

        // @Autowired, @Service, @Component, @Repository
        // HW:  @RestController, @Bean, @Configuration,
        // HW: Scope (czym jest), primary bean*, @Value / @Resource - wstrzykiwanie po NAZWIE, by name

        // DI - Dependency Injection, wstrzykiwanie zależności (this.XXX = YYY), przypisane wartości do pola
        // Guice,
        //@Primary - Służy do wskazania preferowanego beana w przypadku, gdy jest więcej niż jeden bean tego samego typu.
        //@Value - Umożliwia wstrzykiwanie wartości (np. z plików konfiguracyjnych) do pól klasy.
        // @Resource pochodzi od javy a @Autowired od springa
        //Autowired wstrzykuje na podstawie typu a Resource na postawie nazwy
        costRepository.addCost("Pizza", 25.0);
        costRepository.getAll();

        CategoryService categoryService = context.getBean(CategoryService.class);
        Category newCategory = categoryService.saveCategory("Category1");
        Category newCategory2 = categoryService.getCategory("Category1");
        System.out.println(newCategory);
        System.out.println(newCategory2.getName());
    }
}
// dokonczyc to implemetnowac interfejs Food i tez klasy gdzie beda implementowane te rzeczy! (zrobioone)
// (nazwa jedzenia resturacja czy wyjscia na jedzenie) (zrobione)
// , wstawic do gh, zapoznac sie z nowym wzorcem projektowym Repozytorium!
//poczytac pdfa!!