package com.automationExercises.pages;

import com.automationExercises.utilities.BrowserUtils;

import java.io.File;

public class OrderPlacedPage extends BasePage{


    /**
     * İndirilen dosyanın varlığını kontrol eder ve sonucu ekrana yazdırır.
     *
     * @param fileName Dosya adı
     */
    public void checkDownloadedFile( String fileName) {
        String downloadFilePath = System.getProperty("user.dir") + "\\downloads";  // İndirilen dosyaların kaydedileceği dizin
        System.out.println("downloadFilePath = " + downloadFilePath);

        // Dosya yolunu oluştur
        File downloadedFile = new File(downloadFilePath + "\\" + fileName);
        System.out.println("downloadedFile = " + downloadedFile);
        // Dosyanın var olup olmadığını kontrol et
        if (downloadedFile.exists()) {
            System.out.println("Dosya başarıyla indirildi: " + downloadedFile.getAbsolutePath());
        } else {
            System.out.println("Dosya bulunamadı.");
        }
        File downloadDir = new File(downloadFilePath);
        if (downloadDir.canWrite()) {
            System.out.println("Dizin yazma iznine sahip.");
        } else {
            System.out.println("Dizin yazma iznine sahip değil.");
        }
    }




}
