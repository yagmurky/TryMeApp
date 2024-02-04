package com.yagmur.utility;

import com.yagmur.entity.*;
import org.springframework.boot.Banner;

import java.util.ArrayList;
import java.util.List;

public class DataImpl {

    public static void main(String[] args) {

    }

    private static void addProduct() {

        Category giyim = Category.builder()
                .name("Giyim")
                .build();
        Brand zara = Brand.builder()
                .name("Zara")
                .description("Zara / Moda markası")
                .build();
        Model oversize = Model.builder()
                .name("Oversize")
                .description("Salaş, bol kesim kıyafetler. Salaş bir görünüme sahip bu giysiler, rahatlıklarıyla ön plana çıkıyor.")
                .build();

        Product kaseMont = Product.builder()
                .availability(true)
                .discount(10)
                .gender("Kadın")
                .name("Kase Mont")
                .price(2800)
                .stockQuantity(20)
                .description("Kase İnce Çizgili Kaban.")
                .rating(4.5)
                .category(giyim)
                .brand(zara)
                .model(oversize)
                .isNewArrival(true)
                .imageUrl("https://www.zara.com/tr/tr/vatkali-ince-cizgili-kaban-p02171533.html?v1=343023983&v2=2352637")
                .images(new ArrayList<>())
                .features(new ArrayList<>())
                .name("Kase Mont")
                .build();

        //ProductFeaturesTO-DO
        ProductFeatures productFeatures = ProductFeatures.builder()
                .color("Siyah")
                .size("L")
                .material("Coton")
                .pattern("Coton")
                .recycle(true)
                .sleeveType("Uzun kollu")
                .skirtLength("Uzun")
                .waistSize(32)
                .hipSize(32)
                .length(32)
                .description("Kase Mont, ince çizgili.")
                .product(kaseMont)
                .build();
        kaseMont.setFeatures(List.of(productFeatures));
        productFeatures.setProduct(kaseMont);


        //ProductImagesTO-DO
        ProductImages productImages1 = ProductImages.builder().build();
        ProductImages productImages2 = ProductImages.builder().build();
        ProductImages productImages3 = ProductImages.builder().build();

        List<ProductImages> productImagesList = new ArrayList<>();
        productImagesList.add(productImages1);
        productImagesList.add(productImages2);
        productImagesList.add(productImages3);
        kaseMont.setImages(productImagesList);
        productImages1.setProduct(kaseMont);
        productImages2.setProduct(kaseMont);
        productImages3.setProduct(kaseMont);




    }
}


