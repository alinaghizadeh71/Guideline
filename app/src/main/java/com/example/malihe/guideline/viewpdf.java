package com.example.malihe.guideline;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.util.List;

public class viewpdf extends Activity {




    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "guid.pdf";
    //public static final String SAMPLE_FILE1 = "pdf2.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdf);

        pdfView= (PDFView)findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);
        // pdfvieww.fromAsset("guid.pdf").load();

        //displayFromAsset(SAMPLE_FILE);
        // pdfView.fromAsset("guid.pdf").load();
        //alinaghizade

                 /*                   //from load pdf with file
                                           // Toast.makeText(getBaseContext(), "Opening PDF... ", Toast.LENGTH_SHORT).show();
                                            File file = new File("file:///android_asset/guid.pdf");
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            //intent.setDataAndType(Uri.fromFile(file),"application/pdf");
                                            //intent.setDataAndType(Uri.fromFile(file), "guid/pdf");
                                            intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);
                                             // Intent i = Intent.createChooser(intent, "Open File");

                                            try {
                                                startActivity(intent);
                                            } catch (ActivityNotFoundException e) {
                                                //
                                                Toast.makeText(this,"Instruct the user to install a PDF reader here, or something",Toast.LENGTH_LONG).show();
                                            }*/
        //from load pdf with lib


        //aksharo load nemikone
       /* PDFView pdfView=(PDFView)findViewById(R.id.pdfview);
        pdfView.fromAsset("guid.pdf")
                .showMinimap(true)
                .enableSwipe(true)
                .load();*/


      /*  WebView w=(WebView)findViewById(R.id.web);
        w.loadUrl("file:///android_asset/guid.pdf");*/
    }

        private void displayFromAsset(String assetFileName) {
            pdfFileName = assetFileName;

            pdfView.fromAsset(SAMPLE_FILE)
                    .defaultPage(pageNumber)
                    .enableSwipe(true)

                    .swipeHorizontal(false)

                    .enableAnnotationRendering(true)

                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }




    }

   /* private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange((OnPageChangeListener) viewpdf.this)
                .enableAnnotationRendering(true)
                .onLoad((OnLoadCompleteListener) viewpdf.this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }

    }*/



