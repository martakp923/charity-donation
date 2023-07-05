package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    void saveDonation(Donation donation);

    void updateDonation(Donation donation);

    void deleteDonation(long id);


    List<Donation> findAll();

    Integer sumOfBags();

}
