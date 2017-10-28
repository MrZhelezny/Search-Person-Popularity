package ru.geekbrains.traineeship.group2.search_person_popularity_mai.Database;

import java.util.List;

/**
 * Created by skubatko on 28/10/17.
 */

public interface IDatabaseHandler {

    public void AddPerson(Person person);
    Person getPerson(int id);
    List getAllPersons();
    int getPersonsCount();
    int updatePerson(Person person);
    void deletePerson(Person person);
    void deleteAllPersons();

    public void AddKeyword(Keyword keyword);
    Keyword getKeyword(int id);
    List getAllKeywords();
    int getKeywordsCount();
    int updateKeyword(Keyword keyword);
    void deleteKeyword(Keyword keyword);
    void deleteAllKeywords();

    public void AddSite(Site site);
    Site getSite(int id);
    List getAllSites();
    int getSitesCount();
    int updateSite(Site site);
    void deleteSite(Site site);
    void deleteAllSites();

}
