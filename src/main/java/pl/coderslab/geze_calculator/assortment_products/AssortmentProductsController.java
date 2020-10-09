package pl.coderslab.geze_calculator.assortment_products;


import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.geze_calculator.assortment.Assortment;
import pl.coderslab.geze_calculator.media_type.MediaTypeUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
@RequestMapping("/assortmentProduct")
public class AssortmentProductsController {
    private final AssortmentProductsService assortmentProductsService;
    private static final String DIRECTORY = "";
    private static final String DEFAULT_FILE_NAME = "listaProduktow.pdf";
    /*String path = "C:/Users/jaro4/Desktop/Report";
    String fileName = "listaProduktow.pdf";*/

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/all/{assortment}")
    public String findAllProductsAssortmentByAssortment(@PathVariable Assortment assortment, Model model) throws IOException, JRException {
        model.addAttribute("assortmentProducts", assortmentProductsService.findAllByAssortment(assortment));
        model.addAttribute("assortment", assortment);
        assortmentProductsService.exportReport(assortment);
        return "assortmentProducts/assortmentProductsAll";
    }


    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> downloadReport() throws IOException {

        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, DEFAULT_FILE_NAME);
        System.out.println("fileName: " + DEFAULT_FILE_NAME);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + DEFAULT_FILE_NAME);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + LocalDateTime.now().toString() + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }
}
