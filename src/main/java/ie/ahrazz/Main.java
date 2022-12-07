package ie.ahrazz;

import ie.ahrazz.entity.Director;
import ie.ahrazz.repo.DirectorRepo;
import ie.ahrazz.repo.DirectorRepoImp;
import ie.ahrazz.repo.MovieRepo;

import ie.ahrazz.repo.MovieRepoImp;
import ie.ahrazz.services.DirectorService;
import ie.ahrazz.services.DirectorServiceImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("Beans.xml");
        DirectorRepo directorRepo = context.getBean(DirectorRepoImp.class);
        MovieRepo movieRepo = context.getBean(MovieRepoImp.class);

//        movieRepo.findAll().forEach(System.out::println);



        directorRepo.getAll().forEach(System.out::println);
        DirectorService directorService = context.getBean((DirectorServiceImp.class));
        directorService.findADirector(1).ifPresentOrElse(System.out::println, () -> System.out.println("Not a recognised Id"));
        directorService.findADirector(12).ifPresentOrElse(System.out::println, () -> System.out.println("Not a recognised Id"));
        System.out.println("deleted: "+ directorService.deleteDirector(1));
        System.out.println("does not delete: "+ directorService.deleteDirector(12));
//        added the new director and also asked if already exists
        System.out.println("Add director all ok: " + directorService.addDirector(new Director(4,"andy","arens",true)));
        System.out.println("Add director with id already existing: " + directorService.addDirector(new Director(4,"andy","arens",true)));
        System.out.println("Add director where name already used: " +  directorService.addDirector(new Director(4,"andy","arens",true)));

//create print here
        System.out.println("Update director name all ok: " + directorService.changeName(2,"amit"));
        System.out.println("Update director name no such id " + directorService.changeName(7, "newDirector"));
        System.out.println("Update director name where name already used: " + directorService.changeName(2, "amit"));
        System.out.println();
        directorService.findAll().forEach(System.out :: println);
        System.out.println();
        System.out.println();
    }
}