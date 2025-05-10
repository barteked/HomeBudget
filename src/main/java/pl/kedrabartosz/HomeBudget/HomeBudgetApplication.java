package pl.kedrabartosz.HomeBudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;
import pl.kedrabartosz.HomeBudget.repository.ListBasedRepository;

//@SpringBootApplication

    public static void main(String[] args) {
        //SpringApplication.run(HomeBudgetApplication.class, args);
        CostRepository costRepository = new ListBasedRepository();
        costRepository.addCost();
        System.out.println(costRepository.getAll());
    }


// dokonczyc to implemetnowac interfejs Food i tez klasy gdzie beda implementowane te rzeczy! (zrobioone)
// (nazwa jedzenia resturacja czy wyjscia na jedzenie) (zrobione)
// , wstawic do gh, zapoznac sie z nowym wzorcem projektowym Repozytorium!
//poczytac pdfa!!