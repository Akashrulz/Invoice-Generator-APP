package com.example.akash.spm;


        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.util.Date;

        import com.itextpdf.text.BaseColor;
        import com.itextpdf.text.Document;
        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.Element;
        import com.itextpdf.text.Font;
        import com.itextpdf.text.PageSize;
        import com.itextpdf.text.Paragraph;
        import com.itextpdf.text.Phrase;
        import com.itextpdf.text.Rectangle;
        import com.itextpdf.text.pdf.PdfPCell;
        import com.itextpdf.text.pdf.PdfPTable;
        import com.itextpdf.text.pdf.PdfWriter;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class pdf1 extends AppCompatActivity {


    public static String arr[][]=new String [30][4];
    iteminfo1 obj1=new iteminfo1();
        int counter=obj1.count;
        static int v=0;
        static double g=0,total=0;
    String name5,address5,total5,date5;

    public void myfun(int d,String pd1,String pd2,String pd3)
    {

        arr[d][0]=pd1;
        arr[d][1]=pd2;
        arr[d][2]=pd3;

    }


    @Override
    public void onBackPressed()
   {

        super.onBackPressed();
      startActivity(new Intent(this, Homepage.class));
      finish();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        final  String a2, b2;
        Intent z = getIntent();

        a2 = z.getStringExtra("name");
        b2 = z.getStringExtra("add");


        name5=String.valueOf(a2);
       address5=String.valueOf(b2);
       date5=String.valueOf(new Date());

        String path;
        path="/SPM"+"/SPM::"+new Date()+".pdf";
        String FILE = Environment.getExternalStorageDirectory()+path;


        // Add Permission into Manifest.xml
        // <uses-permission
        // android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

        // Create New Blank Document
        Document document = new Document();



        // Create Pdf Writer for Writting into New Created Document
        try {

            PdfWriter.getInstance(document, new FileOutputStream(FILE));

            // Open Document for Writting into document
            document.open();

            // User Define Method

            addMetaData(document);
                // Font Style for Document
                Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
                Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD
                        | Font.UNDERLINE, BaseColor.RED);
                Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
                Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

                // Start New Paragraph
                Paragraph prHead = new Paragraph();
                // Set Font in this Paragraph
                prHead.setFont(titleFont);
                // Add item into Paragraph
                prHead.add("SP  MOULDING WORKS\n");


                // Create Table into Document with 1 Row
                PdfPTable myTable = new PdfPTable(1);
                // 100.0f mean width of table is same as Document size
                myTable.setWidthPercentage(100.0f);

                // Create New Cell into Table
                PdfPCell myCell = new PdfPCell(new Paragraph(""));
                myCell.setBorder(Rectangle.BOTTOM);

                // Add Cell into Table
                myTable.addCell(myCell);

                prHead.setFont(catFont);
                prHead.add("\n\n");
                prHead.setAlignment(Element.ALIGN_CENTER);

                // Add all above details into Document
            document.add(prHead);

            document.add(myTable);




                // Now Start another New Paragraph
                Paragraph prPersinalInfo = new Paragraph();
                prPersinalInfo.setFont(smallBold);


                prPersinalInfo.add("RashtraBhushan Housing Society Near Ganpati Mandir\n");
                prPersinalInfo.add("Rupinagar Talwade Pune-412114\n");
                prPersinalInfo.add("City: Pune. State:Maharashtra\n");
                prPersinalInfo.add("Country:India Zip Code:412114\n");
                prPersinalInfo.add("Mobile:8149032013  Email: spmouldingworks@gmail.com \n");
            prPersinalInfo.add("GSTIN : 27AXIPP5382M1ZP \n");
            prPersinalInfo.add("    \n");

                prPersinalInfo.setAlignment(Element.ALIGN_CENTER);


            document.add(prPersinalInfo);


            // Create Table into Document with 1 Row
            PdfPTable myTable1 = new PdfPTable(1);
            // 100.0f mean width of table is same as Document size
            myTable1.setWidthPercentage(100.0f);

            // Create New Cell into Table
            PdfPCell myCell1 = new PdfPCell(new Paragraph(""));
            myCell1.setBorder(Rectangle.BOTTOM);

            // Add Cell into Table
            myTable1.addCell(myCell1);

            prHead.setFont(catFont);
            prHead.add("\n\n");
            prHead.setAlignment(Element.ALIGN_CENTER);

            // Add all above details into Document

            document.add(myTable1);





            Paragraph prPersinalInfo1 = new Paragraph();

            prPersinalInfo1.setFont(smallBold);


            prPersinalInfo1.add("\n");
            prPersinalInfo1.add("To,");
            prPersinalInfo1.add("\n");
            prPersinalInfo1.add("Name: ");

            prPersinalInfo1.add(String.valueOf(a2));
            prPersinalInfo1.add("\n");
            prPersinalInfo1.add("Address: ");

            prPersinalInfo1.add(String.valueOf(b2));
            prPersinalInfo1.add("\n");
            prPersinalInfo1.add("\n");

            prPersinalInfo1.add("    \n");

            prPersinalInfo1.setAlignment(Element.ALIGN_LEFT);


            document.add(prPersinalInfo1);



            document.add(myTable);



            Paragraph prPersinalInfo2 = new Paragraph();
            prPersinalInfo2.setFont(smallBold);


            prPersinalInfo2.add(" \n");

            prPersinalInfo2.setAlignment(Element.ALIGN_CENTER);


            document.add(prPersinalInfo2);



            PdfPTable table = new PdfPTable(5);
            float[] columnWidths = new float[]{10f, 50f, 12f, 14f,14f};
            table.setWidths(columnWidths);

            // t.setBorderColor(BaseColor.GRAY);
            // t.setPadding(4);
            // t.setSpacing(4);
            // t.setBorderWidth(1);



            PdfPCell c1 = new PdfPCell(new Phrase("Sr No"));

            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Item Name"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Quantity"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Rate"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Amount"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            System.out.print(arr[1][0]);

                try {


                    for (int i = 1; i <=counter; i++) {


                        table.setHeaderRows(1);


                        table.addCell(String.valueOf(i));
                        table.addCell(String.valueOf(arr[i][0]));


                        table.addCell(String.valueOf(arr[i][1]));
                        table.addCell(String.valueOf(arr[i][2]));

                        table.addCell(String.valueOf((Integer.parseInt(arr[i][1]))*((Integer.parseInt(arr[i][2])))));

                        v=v+(Integer.parseInt(arr[i][1]))*((Integer.parseInt(arr[i][2])));
                    }

                }
                catch (Exception e)
                {
                    System.out.print("error" + e);
                }


              g=(v*(0.28));
                String a=String.format(("%.2f"),g);

                 total=(v+g);
            total5=String.valueOf(total);

            table.setHeaderRows(1);

            String method="record";
            BackgroundTask backgroundTask=new BackgroundTask(this);
            backgroundTask.execute(method,name5,address5,total5,date5);



            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");

            table.setHeaderRows(1);


            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");

            table.setHeaderRows(1);


            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");

            table.setHeaderRows(1);


            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("GST");
            table.addCell(String.valueOf(a));

            table.setHeaderRows(1);


            table.addCell("\n");
            table.addCell("\n");
            table.addCell("\n");
            table.addCell("TOTAL");
            table.addCell(String.valueOf(total));




            document.add(table);




            Paragraph prPersinalInfo3 =  new Paragraph();

            prPersinalInfo3.setFont(smallBold);



            prPersinalInfo3.add("\n");

            prPersinalInfo3.add("\n");
            prPersinalInfo3.add("\n");
            prPersinalInfo3.add("\n");
            prPersinalInfo3.add("Stamp");
            prPersinalInfo3.add("\n");
            prPersinalInfo3.add("\n");



            prPersinalInfo3.setAlignment(Element.ALIGN_RIGHT);


            document.add(prPersinalInfo3);


            Paragraph prPersinalInfo4 =  new Paragraph();

            prPersinalInfo4.setFont(smallBold);

            prPersinalInfo4.add("\n");
            prPersinalInfo4.add("Sign");
            prPersinalInfo4.add("\n");
            prPersinalInfo4.add("\n");


            prPersinalInfo4.setAlignment(Element.ALIGN_RIGHT);
            document.add(prPersinalInfo4);





        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Close Document after writting all content
        document.close();


        final Button btn1 = findViewById(R.id.close);
        final Button btn2= findViewById(R.id.home);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //finish();
                //System.exit(0);
                btn2.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);

                finish();
            }
        });
    }

    // Set PDF document Properties

    public void addMetaData(Document document)

    {
        document.addTitle("INVOICE");
        document.addSubject("BILL DETAILS");
        document.addKeywords("Personal,	Education, Skills");
        document.addAuthor("TAG");
        document.addCreator("TAG");
    }




}
