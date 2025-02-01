package com.revature.bootpie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.revature.bootpie.Exceptions.ResourceNotFoundException;
import com.revature.bootpie.models.Pie;

@Service
public class PieService {
    private List<Pie> pieList = new ArrayList<>();

    {
        Pie pie1 = new Pie(800, "Cherry", 8);
        Pie pie2 = new Pie(700, "Apple", 3);
        Pie pie3 = new Pie(10000, "BootPie", 8);

        pieList.add(pie1);
        pieList.add(pie2);
        pieList.add(pie3);
    }

    public Pie getRandomPie() {
        int randomInt = new Random().nextInt(pieList.size());
        return pieList.get(randomInt);
    }

    public List<Pie> getPieList() {
        return pieList;
    }

    public Pie findPie(String pieName) throws ResourceNotFoundException {
        for (Pie pie:pieList) {
            if (pie.getPieName().equals(pieName))
                return pie; 
        }
        throw new ResourceNotFoundException(pieName + " was not found. Please check name or try another.");
    }

    public List<Pie> getPieByCalories(int limit) throws ResourceNotFoundException {
        List<Pie> caloriePieList = new ArrayList<>();

        for(Pie pie:pieList) {
            if(pie.getCalories() <= limit) {
                caloriePieList.add(pie);
            }       
        }
        if (caloriePieList.isEmpty()) throw new ResourceNotFoundException("No pie exist with calories equal to or lower than " + limit);
        return caloriePieList;
    }

    public void deletePie(String pieName) {
        pieList.removeIf(pie -> pie.getPieName().equals(pieName));
    }

    public void patchPie(String pieName, int calories, int slicesAvailable) throws ResourceNotFoundException {
        for(Pie pie:pieList) {
            if(pie.getPieName().equals(pieName)){
                if(calories > 0) pie.setCalories(calories);
                if(slicesAvailable > 0) pie.setSlicesAvailable(slicesAvailable);
                return;
            }
        }
        throw new ResourceNotFoundException(pieName + " was not found. Please check name or try another.");
    }

    public void updatePie(Pie updatedPie) throws ResourceNotFoundException {
        if(pieList.removeIf(pie -> pie.getPieName().equals(updatedPie.getPieName()))) {
            pieList.add(updatedPie);
            return;
        }
        throw new ResourceNotFoundException(updatedPie.getPieName() + " was not found. Please check name or try another");
    }

    public void addNewPie(Pie newPie) {
        pieList.add(newPie);
    }

}
