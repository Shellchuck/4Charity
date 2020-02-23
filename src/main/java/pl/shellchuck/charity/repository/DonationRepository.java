package pl.shellchuck.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shellchuck.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
