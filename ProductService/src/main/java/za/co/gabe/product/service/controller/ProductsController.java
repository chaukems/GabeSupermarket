/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.product.service.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import za.co.gabe.product.service.entity.Product;
import za.co.gabe.product.service.repository.ProductsRepository;
import za.co.gabe.product.service.model.Response;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ABMC684
 */
@RestController
public class ProductsController {

    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private String userDir = System.getProperty("user.dir");

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/findAll")
    public @ResponseBody
    List<Product> findAll() {
        return productsRepository.findAll();
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Response addProduct(@RequestBody Product product) {

        Response response = new Response();

        try {
            File tmpDir = new File(TMP_DIR);
            UUID uuid = UUID.randomUUID();

            if (!tmpDir.exists()) {
                tmpDir.mkdir();
            }

            String webAppsDir = userDir.replace("bin", "webapps");

            String generatedUuid = uuid.toString().replaceAll("-", "_");

            String imagePath = product.getServer() + generatedUuid + "\\prodImage.png";
            String fileName = webAppsDir + "\\Images\\" + generatedUuid + "\\prodImage.png";

            String dir = webAppsDir + "\\Images\\" + generatedUuid;

            File file = new File(dir);
            file.mkdir();

            String base64Image = product.getImageBase64String().split(",")[1];

            BufferedImage image = null;
            byte[] imageByte;

            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(base64Image);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();

// write the image to a file
            File outputfile = new File(fileName);
            ImageIO.write(image, "png", outputfile);

            product.setImage(imagePath);

            productsRepository.addProduct(product);

            response.setFailed(false);
            response.setMessage("Product added successfully");

            return response;

        } catch (Exception ex) {
            response.setFailed(true);
            response.setMessage(ex.getMessage());
            return response;
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    Response updateProduct(@RequestBody Product product) {
        Response response = new Response();
        try {
            productsRepository.updateProduct(product);

            response.setFailed(false);
            response.setMessage("Product updated successfully");
            return response;
        } catch (Exception ex) {

            ex.printStackTrace();
            response.setFailed(true);
            response.setMessage(ex.getMessage());
            return response;

        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    Response deleteProduct(@RequestBody Product product) {
        Response response = new Response();

        try {
            productsRepository.deleteProduct(product);
            response.setFailed(false);
            response.setMessage("Product deleted successfully");
            return response;

        } catch (Exception ex) {
            response.setFailed(true);
            response.setMessage(ex.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/findById/{productId}", method = RequestMethod.GET)
    public @ResponseBody
    Product findById(@PathVariable int productId) {
        return productsRepository.findById(productId);
    }

    @RequestMapping(value = "/getByBarcode/{barcode}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProductByBarcode(@PathVariable long barcode) {
        return productsRepository.getByBarcode(barcode);
    }

    @RequestMapping(value = {"/generateBarcode/{barCode}/{server}"}, method = RequestMethod.GET)
    public Response GenerateBarcode(@PathVariable String barCode, @PathVariable String server) {
        Response response = null;
        try {

            File tmpDir = new File(TMP_DIR);

            if (!tmpDir.exists()) {
                tmpDir.mkdir();
            }

            String webAppsDir = userDir.replace("bin", "webapps");

            String imagePath = "http://" + server + "\\Images\\barcodes\\" + barCode + ".jpg";
            String fileName = webAppsDir + "\\Images\\barcodes\\" + barCode + ".jpg";

            String dir = webAppsDir + "\\Images\\barcodes";

            File file = new File(dir);
            file.mkdir();

            BarcodeUtil util = BarcodeUtil.getInstance();
            BarcodeGenerator gen = util.createBarcodeGenerator(buildCfg("ean-13"));

            OutputStream fout = new FileOutputStream(fileName);
            int resolution = 200;
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    fout, "image/jpeg", resolution, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            gen.generateBarcode(canvas, barCode);
            canvas.finish();

            response = new Response();

            response.setFailed(false);
            response.setMessage(imagePath);

            return response;
        } catch (Exception ex) {
            response = new Response();

            response.setFailed(true);
            response.setMessage(ex.getMessage());
            return response;
        }
    }

    private Configuration buildCfg(String type) {
        DefaultConfiguration cfg = new DefaultConfiguration("barcode");

        //Bar code type
        DefaultConfiguration child = new DefaultConfiguration(type);
        cfg.addChild(child);

        //Human readable text position
        DefaultConfiguration attr = new DefaultConfiguration("human-readable");
        DefaultConfiguration subAttr = new DefaultConfiguration("placement");
        subAttr.setValue("bottom");
        attr.addChild(subAttr);

        child.addChild(attr);
        return cfg;
    }

}
