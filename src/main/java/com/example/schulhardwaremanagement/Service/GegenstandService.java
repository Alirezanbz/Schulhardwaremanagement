package com.example.schulhardwaremanagement.Service;
import com.example.schulhardwaremanagement.DTO.GegenstandDto;
import com.example.schulhardwaremanagement.Entity.Gebaeude;
import com.example.schulhardwaremanagement.Entity.Gegenstand;
import com.example.schulhardwaremanagement.Entity.GegenstandsDetail;
import com.example.schulhardwaremanagement.Entity.Lagerort;
import com.example.schulhardwaremanagement.Repository.GebaeudeRepository;
import com.example.schulhardwaremanagement.Repository.GegenstandRepository;
import com.example.schulhardwaremanagement.Repository.GegenstandsDetailRepository;
import com.example.schulhardwaremanagement.Repository.LagerortRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class GegenstandService {

    @Autowired
    private GegenstandRepository gegenstandRepository;
    @Autowired
    private GegenstandsDetailRepository gegenstandsDetailRepository;
    @Autowired
    private LagerortRepository lagerortRepository;
    @Autowired
    private GebaeudeRepository gebaeudeRepository;




    public List<Gegenstand> findAllGegenstaende() {
        return gegenstandRepository.findAll();
    }
    public Gegenstand addGegenstand(GegenstandDto gegenstandDto) {

        Gebaeude gebaeude = new Gebaeude();
        gebaeude.setGebaeudeName(gegenstandDto.getGebaeudeName());
        gebaeude = gebaeudeRepository.save(gebaeude);


        Lagerort lagerort = new Lagerort();
        lagerort.setLagerortName(gegenstandDto.getLagerortName());
        lagerort.setGebaeude(gebaeude);
        lagerort = lagerortRepository.save(lagerort);


        GegenstandsDetail gegenstandsDetail = new GegenstandsDetail();
        gegenstandsDetail.setDetailsName(gegenstandDto.getDetailsName());
        gegenstandsDetail.setBeschreibung(gegenstandDto.getBeschreibung());
        gegenstandsDetail.setBildpfad(gegenstandDto.getBildpfad());
        gegenstandsDetail = gegenstandsDetailRepository.save(gegenstandsDetail);


        Gegenstand gegenstand = new Gegenstand();
        gegenstand.setStatus(gegenstandDto.getStatus());
        gegenstand.setGegenstandsDetail(gegenstandsDetail);
        gegenstand.setLagerort(lagerort);
        return gegenstandRepository.save(gegenstand);
    }

    public Gegenstand updateGegenstand(Integer id, Gegenstand gegenstand) {
        gegenstand.setGegenstandsID(id);
        return gegenstandRepository.save(gegenstand);
    }

    public void deleteGegenstand(Integer id) {
        gegenstandRepository.deleteById(id);
    }

    public Optional<Gegenstand> getGegenstandById(Integer id) {
        return gegenstandRepository.findById(id);
    }

}

