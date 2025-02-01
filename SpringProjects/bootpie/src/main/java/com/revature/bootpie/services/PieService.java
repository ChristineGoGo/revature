package com.revature.bootpie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

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

}
