package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Override
    public void saveDonation(Donation donation) {
        donationRepository.save(donation);

    }

    @Override
    public void updateDonation(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void deleteDonation(long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Integer sumOfBags() {
        return donationRepository.sumOfBags();
    }

}
