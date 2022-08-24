package com.example.imagepro.Auth;

import static android.provider.SyncStateContract.Columns.DATA;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


import com.example.imagepro.R;
import com.example.imagepro.database.DATA;
import com.example.imagepro.database.DATA;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


import com.google.mlkit.common.model.DownloadConditions;


import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Button;
import android.widget.TextView;

import com.example.imagepro.MainActivity;


public class HomeActivity extends AppCompatActivity {

    Button speakButton ;
    Button sign_lan_btn;
    Button setting_btn;
    String st;
    private EditText editText;
    private EditText Transelation;

    private Translator translatorGerman;
    private Translator translatorArabic;
    private Translator translatorKorean;
    private Translator translatorEnglish;
    private Translator translatorFrench;
    private Translator translatorItalian;
    private Translator translatorIcelandic;
    private Translator translatoSpanish;
    private  Translator translatorIcelandicToEn;
    private Translator translatorIcelandicToArabic;
    private Translator translatorfromGermanToEnglish;
    private Translator translatorfromGermanToArabic;
    private Translator translatorKoreanToEnglish;
    private Translator translatorKoreanToArabic;
    private Translator translatorFrenchToEnglish;
    private Translator translatorFrenchToArabic;
    private Translator translatorSpanishToEnglish;
    private Translator translatorSpanishToArabic;
    private Translator translatorItalianToArabic;

    Boolean cliced=false;
    private Boolean en=false;
    private Boolean ar=false;
    private Boolean ger=false;
    private Boolean spa=false;
    private Boolean fre=false;
    private Boolean ice=false;
    private Boolean ita=false;
    private Boolean kor=false;
    private Boolean booleanGerman = false;
    private Boolean booleanArabic = false;
    private Boolean booleanKorean = false;
    private Boolean booleanEnglish = false;
    private Boolean booleanFrench=false;
    private Boolean booleanItalian=false;
    private Boolean booleanIclandic=false;
    private Boolean booleanSpanish=false;
    private Boolean booleanIcelandicToEn=false;
    private Boolean booleanIcelandicToArabic=false;
    private Boolean booleanGermanToEnglish=false;
    private Boolean booleanGermanToArabic=false;
    private Boolean booleanKoreanToEnglish=false;
    private Boolean booleanKoreanToArabic=false;
    private Boolean booleanFrenchToEnglish=false;
    private Boolean booleanFrenchToArabic=false;
    private Boolean booleanSpanishToEnglish=false;
    private Boolean booleanSpanishToArabic=false;
    private Boolean booleanItalianToArabic=false;



    String[] items={"English","Arabic","German","Korean","French","Spanish","Italian","Icelandic"};

    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView drop_menu;
    ArrayAdapter<String> adapterItems;
    DATA database = new DATA(HomeActivity.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialization();

        adapterItems = new ArrayAdapter<String>(HomeActivity.this, R.layout.list_item, items);

        TranslatorOptions translatorOptionsGerman = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.GERMAN)
                .build();
        TranslatorOptions translatorOptionsArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.ARABIC)
                .build();
        TranslatorOptions translatorOptionsKorean = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.KOREAN)
                .build();
        TranslatorOptions translatorOptionsEnglish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();

        TranslatorOptions translatorOptionsFrench = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.FRENCH)
                .build();

        TranslatorOptions translatorOptionsSpanish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.SPANISH)
                .build();
        TranslatorOptions translatorOptionsItalian = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.ITALIAN)
                .build();
        TranslatorOptions translatorOptionsIcelandic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.ICELANDIC)
                .build();

        TranslatorOptions translatorFromIcelandicToEn = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ICELANDIC)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();

        TranslatorOptions translatorFromIcelandicToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.ICELANDIC)
                .build();

        TranslatorOptions translatorGermanToEnglish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.GERMAN)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();

        TranslatorOptions translatorGermanToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.GERMAN)
                .build();

        TranslatorOptions translatorFromKoreanToEnglish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.KOREAN)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();
        TranslatorOptions translatorFromKoreanToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.KOREAN)
                .build();
        TranslatorOptions translatorFromFrenchToEnglish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.FRENCH)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();
        TranslatorOptions translatorFromFrenchToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.FRENCH)
                .build();
        TranslatorOptions translatorFromSpanishToEnglish = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build();

        TranslatorOptions translatorFromSpanishToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.SPANISH)
                .build();

        TranslatorOptions translatorFromItalianToArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ARABIC)
                .setTargetLanguage(TranslateLanguage.ITALIAN)
                .build();
        translatorItalianToArabic=Translation.getClient(translatorFromItalianToArabic);
        translatorGerman = Translation.getClient(translatorOptionsGerman);
        translatorArabic = Translation.getClient(translatorOptionsArabic);
        translatorKorean = Translation.getClient(translatorOptionsKorean);
        translatorEnglish = Translation.getClient(translatorOptionsEnglish);
        translatorFrench=Translation.getClient(translatorOptionsFrench);
        translatorItalian =Translation.getClient(translatorOptionsItalian);
        translatoSpanish =Translation.getClient(translatorOptionsSpanish);
        translatorIcelandic=Translation.getClient(translatorOptionsIcelandic);
        translatorIcelandicToEn = Translation.getClient(translatorFromIcelandicToEn);
        translatorIcelandicToArabic = Translation.getClient(translatorFromIcelandicToArabic);
        translatorfromGermanToEnglish = Translation.getClient(translatorGermanToEnglish);
        translatorfromGermanToArabic = Translation.getClient(translatorGermanToArabic);
        translatorKoreanToEnglish = Translation.getClient(translatorFromKoreanToEnglish);
        translatorKoreanToArabic = Translation.getClient(translatorFromKoreanToArabic);
        translatorFrenchToEnglish = Translation.getClient(translatorFromFrenchToEnglish);
        translatorFrenchToArabic = Translation.getClient(translatorFromFrenchToArabic);
        translatorSpanishToEnglish = Translation.getClient(translatorFromSpanishToEnglish);
        translatorSpanishToArabic = Translation.getClient(translatorFromSpanishToArabic);
        downloadModel();


        autoCompleteTextView.setAdapter(adapterItems);
        drop_menu.setAdapter(adapterItems);
        drop_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item2 = adapterView.getItemAtPosition(i).toString();
             switch (item2){
                 case "English":
                     en=true;
                     ar=false;
                     ice=false;
                     ita=false;
                     spa=false;
                     kor=false;
                     ger=false;
                     fre=false;
                     break;
                 case "German":
                     en=false;
                     ar=false;
                     ice=false;
                     ita=false;
                     spa=false;
                     kor=false;
                     ger=true;
                     fre=false;
                     break;
                 case "Korean":
                     en=false;
                     ar=false;
                     ice=false;
                     ita=false;
                     spa=false;
                     kor=true;
                     ger=false;
                     fre=false;
                     break;
                 case "French":
                     en=false;
                     ar=false;
                     ice=false;
                     ita=false;
                     spa=false;
                     kor=false;
                     ger=false;
                     fre=true;
                     break;
                 case "Spanish":
                     en=false;
                     ar=false;
                     ice=false;
                     ita=false;
                     spa=true;
                     kor=false;
                     ger=false;
                     fre=false;
                     break;
                 case "Italian":
                     en=false;
                     ar=false;
                     ice=false;
                     ita=true;
                     spa=false;
                     kor=false;
                     ger=false;
                     fre=false;
                     break;

                 case "Arabic":
                     en=false;
                     ar=true;
                     ice=false;
                     ita=false;
                     spa=false;
                     kor=false;
                     ger=false;
                     fre=false;
                     break;
                 case "Icelandic":
                     en=false;
                     ar=false;
                     ice=true;
                     ita=false;
                     spa=false;
                     kor=false;
                     ger=false;
                     fre=false;
                     break;

             }
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("English") && ar) {

                    buttonEnglish(view);

                } else if ((item.equals("English") && fre)) {
                    buttonFrenchToEnglish(view);

                } else if ((item.equals("English") && ger)) {
                    buttonGermanToEnglish(view);

                } else if ((item.equals("English") && ice)) {
                    buttonIcelandicToEn(view);

                } else if ((item.equals("English") && kor)) {
                    buttonKoreanToEnglish(view);

                } else if ((item.equals("English") && spa)) {
                    buttonSpanishToEnglish(view);

                } else if(item.equals("Spanish")&&ar) {
                    buttonSpanishToArabic(view);
                }else if ((item.equals("Spanish"))) {
                    buttonSpanish(view);
                }else if(item.equals("German") &&ar) {
                    buttonGermanToArabic(view);
                }else if ((item.equals("German"))) {
                    buttonGerman(view);
                } else if(item.equals("French") &&ar) {
                    buttonFrenchToArabi(view);
                }else if ((item.equals("French"))) {
                    buttonFrench(view);
                }else if(item.equals("Italian") &&ar) {
                    buttonItalianToArabic(view);
                }else if ((item.equals("Italian"))) {
                    buttonItalian(view);
                } else if((item.equals("Korean")) &&ar) {
                    buttonKoreanToArabic(view);
                } else if ((item.equals("Korean"))) {
                    buttonKorean(view);
                }else if ((item.equals("Arabic"))&&en) {
                    buttonArabic(view);
                }


            }



        });


        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");
                startActivityForResult(intent, 100);
            }

        });
        sign_lan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliced=true;
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
            }
        });

            Intent secound=getIntent();
            st = secound.getStringExtra("value");
            editText.setText(st, TextView.BufferType.EDITABLE);
            cliced=false;



        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(HomeActivity.this , SettingActivity.class));
            finish();
            }
        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == 100 || requestCode == RESULT_OK)){
            editText.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }


    }

    private void downloadModel(){
        DownloadConditions downloadConditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();

        translatorGerman.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanGerman = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanGerman = false;
                    }
                });

        translatorArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanArabic = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanArabic = false ;
                    }
                });

        translatorKorean.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanKorean = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanKorean = false;
                    }
                });
        translatorEnglish.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanEnglish = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanEnglish = false;
                    }
                });
        translatorFrench.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                      booleanFrench=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanFrench=false;
                    }
                });
        translatorIcelandic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanIclandic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanIclandic=false;
                    }
                });
        translatoSpanish.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanSpanish=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanSpanish=false;
                    }
                });
        translatorItalian.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanItalian=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanItalian=false;
                    }
                });
        translatorFrenchToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanFrenchToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanFrenchToArabic=false;
                    }
                });
        translatorFrenchToEnglish.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanFrenchToEnglish=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanFrenchToEnglish=false;
                    }
                });
        translatorfromGermanToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanGermanToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanGermanToArabic=false;
                    }
                });
        translatorfromGermanToEnglish.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanGermanToEnglish=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanGermanToEnglish=false;
                    }
                });
        translatorIcelandicToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanIcelandicToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanIcelandicToArabic=false;
                    }
                });
        translatorIcelandicToEn.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanIcelandicToEn=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanIcelandicToEn=false;
                    }
                });
        translatorKoreanToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanKoreanToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanKoreanToArabic=false;
                    }
                });
        translatorKoreanToEnglish.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanKoreanToEnglish=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanKoreanToEnglish=false;
                    }
                });
        translatorSpanishToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanSpanishToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanSpanishToArabic=false;
                    }
                });
        translatorItalianToArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanItalianToArabic=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanItalianToArabic=false;
                    }
                });
    }

    public void buttonDownloadModel(View view){
        downloadModel();
    }

    public void buttonGerman(View view){

        if (booleanGerman){
            translatorGerman.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }
    }
    public void buttonArabic(View view){

        if (booleanArabic) {
            translatorArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }
    }
    public void buttonKorean(View view){
        if (booleanKorean) {
            translatorKorean.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonEnglish(View view){
        if (booleanEnglish) {
            translatorEnglish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }

    }
    public void buttonFrench(View view){
   if(booleanFrench) {
       translatorFrench.translate(editText.getText().toString())
               .addOnSuccessListener(new OnSuccessListener<String>() {
                   @Override
                   public void onSuccess(String s) {
                       Transelation.setText(s);
                       database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());


                   }
               })
               .addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Transelation.setText(e.toString());
                   }
               });

   }

    }
    public void buttonIcelandic(View view){
        if (booleanIclandic) {
            translatorIcelandic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });
        }

    }
    public void buttonSpanish(View view){
        if (booleanSpanish) {
            translatoSpanish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonItalian(View view){
        if (booleanItalian) {
            translatorItalian.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonFrenchToArabi(View view){
        if (booleanFrenchToArabic) {
            translatorFrenchToArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }
    }
    public void buttonFrenchToEnglish(View view){
        if (booleanFrenchToEnglish) {
            translatorFrenchToEnglish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonGermanToArabic(View view){
    if(booleanGermanToArabic) {
        translatorfromGermanToArabic.translate(editText.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Transelation.setText(s);
                        database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Transelation.setText(e.toString());
                    }
                });

    }

    }
    public void buttonGermanToEnglish(View view){
        if (booleanGermanToEnglish) {
            translatorfromGermanToEnglish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonIcelandicToArabic(View view){
        if (booleanIcelandicToArabic) {
            translatorIcelandicToArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonIcelandicToEn(View view){
        if (booleanIcelandicToEn) {
            translatorIcelandicToEn.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonKoreanToArabic(View view){
        if (booleanKoreanToArabic) {
            translatorKoreanToArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });

        }

    }
    public void buttonKoreanToEnglish(View view){
        if (booleanKoreanToEnglish) {
            translatorKoreanToEnglish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }

    }
    public void buttonSpanishToArabic(View view){
        if (booleanSpanishToArabic) {
            translatorSpanishToArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }

    }   public void buttonItalianToArabic(View view){
        if (booleanItalianToArabic) {
            translatorItalianToArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }

    }
    public void buttonSpanishToEnglish(View view){
        if (booleanSpanishToEnglish) {
            translatorSpanishToEnglish.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Transelation.setText(s);
                            database.Translate(editText.getText().toString().trim(),Transelation.getText().toString());

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Transelation.setText(e.toString());
                        }
                    });


        }

    }


    public void initialization(){

        speakButton = (Button) findViewById(R.id.speech);
        sign_lan_btn = (Button) findViewById(R.id.sign_language_btn);
        setting_btn = (Button) findViewById(R.id.setting_btn);
        editText = findViewById(R.id.speechText);
        Transelation = findViewById(R.id.Transelation);
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        drop_menu = findViewById(R.id.dropdown_menu);




    }
}


