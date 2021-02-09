package com.github.arpitmehra.nameo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Configuration
public class NameOService {

    private static final String SPACE = " ";

    private static List<String> adjectiveList;

    private static List<String> verbList;

    private static List<String> nounList;

    @Value("#{'${seed.words.adjectives}'.split(',')}")
    public void setAdjectiveList(List<String> adjectiveList) {
        this.adjectiveList = adjectiveList;
    }

    @Value("#{'${seed.words.verbs}'.split(',')}")
    public void setVerbList(List<String> verbList) {
        NameOService.verbList = verbList;
    }

    @Value("#{'${seed.words.nouns}'.split(',')}")
    public void setNounList(List<String> nounList) {
        this.nounList = nounList;
    }

    public String generateLoginCode(int length) {
        Random random = new Random();
        StringBuilder loginCode = new StringBuilder();
        loginCode.append(SPACE).append(verbList.get(random.nextInt(verbList.size() - 1)));
        loginCode.append(SPACE).append(nounList.get(random.nextInt(nounList.size() - 1)));
        while (length - 2 > 0) {
            length--;
            loginCode.insert(0, SPACE + adjectiveList.get(random.nextInt(adjectiveList.size() - 1)));
        }
        return loginCode.toString().toLowerCase();
    }
}
