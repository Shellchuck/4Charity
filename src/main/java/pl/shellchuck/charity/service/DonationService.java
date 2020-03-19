package pl.shellchuck.charity.service;

import pl.shellchuck.charity.entity.Donation;

import java.util.NoSuchElementException;

public interface DonationService {

    Donation addDonation(Donation donation);

    Donation searchDonationById(Long id) throws NoSuchElementException;

}
