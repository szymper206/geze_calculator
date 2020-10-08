package pl.coderslab.geze_calculator.assortment_products;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import pl.coderslab.geze_calculator.assortment.Assortment;
import pl.coderslab.geze_calculator.media_type.MediaTypeUtils;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
@RequiredArgsConstructor
public class AssortmentProductsService {
    private final AssortmentProductsRepository assortmentProductsRepository;


    public void saveAssortmentProducts(AssortmentProducts assortmentProducts) {
        assortmentProductsRepository.save(assortmentProducts);
    }

    public List<AssortmentProducts> findAllByAssortment (Assortment assortment) {
        return assortmentProductsRepository.findAllByAssortment(assortment);
    }

    public void exportReport(Assortment assortment) throws FileNotFoundException, JRException {
        String path = "C:/Users/jaro4/Desktop/Report";
        String fileName = "/listaProduktow.pdf";
        List<AssortmentProducts> assortmentProductsList = findAllByAssortment(assortment);
        File file = ResourceUtils.getFile("classpath:assortmentProducts.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(assortmentProductsList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "GezeCalculator");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + fileName);
    }



}
