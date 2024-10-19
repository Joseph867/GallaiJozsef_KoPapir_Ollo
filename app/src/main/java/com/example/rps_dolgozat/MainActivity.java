package com.example.rps_dolgozat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView botLife1;
    private ImageView botLife2;
    private ImageView botLife3;
    private ImageView playerLife1;
    private ImageView playerLife2;
    private ImageView playerLife3;
    private TextView tie;
    private ImageView ImageViewBot;
    private ImageView ImageViewPlayer;
    private ImageView rock;
    private ImageView paper;
    private ImageView scissors;
    private Random random;
    private int botLife = 3;
    private int playerLife = 3;
    private int tieCounter = 0;
    private int botChoice = 0;
    private int playerChoice = 0;
    private int RandomNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = 1;
                ImageViewPlayer.setImageResource(R.drawable.rock);
                RandomNumber = random.nextInt(3);
                if (RandomNumber == 0) {
                    ImageViewBot.setImageResource(R.drawable.rock);
                    tieCounter++;
                    tie.setText("Döntetlenek száma: " + tieCounter);
                } else if (RandomNumber == 1) {
                    ImageViewBot.setImageResource(R.drawable.paper);
                    playerLife--;
                    if (playerLife == 2) {
                        playerLife3.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 1) {
                        playerLife2.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 0) {
                        playerLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Vesztettél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                } else {
                    ImageViewBot.setImageResource(R.drawable.scissors);
                    botLife--;
                    if (botLife == 2) {
                        botLife3.setImageResource(R.drawable.heart1);
                    } else if (botLife == 1) {
                        botLife2.setImageResource(R.drawable.heart1);
                    } else if (botLife == 0) {
                        botLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Nyertél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                }
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = 2;
                ImageViewPlayer.setImageResource(R.drawable.paper);
                RandomNumber = random.nextInt(3);
                if (RandomNumber == 0) {
                    ImageViewBot.setImageResource(R.drawable.rock);
                    botLife--;
                    if (botLife == 2) {
                        botLife3.setImageResource(R.drawable.heart1);
                    } else if (botLife == 1) {
                        botLife2.setImageResource(R.drawable.heart1);
                    } else if (botLife == 0) {
                        botLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Nyertél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                } else if (RandomNumber == 1) {
                    ImageViewBot.setImageResource(R.drawable.paper);
                    tieCounter++;
                    tie.setText("Döntetlenek száma: " + tieCounter);
                } else {
                    ImageViewBot.setImageResource(R.drawable.scissors);
                    playerLife--;
                    if (playerLife == 2) {
                        playerLife3.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 1) {
                        playerLife2.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 0) {
                        playerLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Vesztettél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                }
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoice = 3;
                ImageViewPlayer.setImageResource(R.drawable.scissors);
                RandomNumber = random.nextInt(3);
                if (RandomNumber == 0) {
                    ImageViewBot.setImageResource(R.drawable.rock);
                    playerLife--;
                    if (playerLife == 2) {
                        playerLife3.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 1) {
                        playerLife2.setImageResource(R.drawable.heart1);
                    } else if (playerLife == 0) {
                        playerLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Vesztettél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                         newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                } else if (RandomNumber == 1) {
                    ImageViewBot.setImageResource(R.drawable.paper);
                    botLife--;
                    if (botLife == 2) {
                        botLife3.setImageResource(R.drawable.heart1);
                    } else if (botLife == 1) {
                        botLife2.setImageResource(R.drawable.heart1);
                    } else if (botLife == 0) {
                        botLife1.setImageResource(R.drawable.heart1);
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Nyertél")
                                .setMessage("Szeretnél e új játékot kezdeni?")
                                .setCancelable(false)
                                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newGame();
                                    }
                                }).create();
                        alertDialog.show();
                    }
                } else {
                    ImageViewBot.setImageResource(R.drawable.scissors);
                    tieCounter++;
                    tie.setText("Döntetlenek száma: " + tieCounter);
                }
            }
        });
    }

        public void newGame() {
            botLife1.setImageResource(R.drawable.heart2);
            botLife2.setImageResource(R.drawable.heart2);
            botLife3.setImageResource(R.drawable.heart2);
            playerLife1.setImageResource(R.drawable.heart2);
            playerLife2.setImageResource(R.drawable.heart2);
            playerLife3.setImageResource(R.drawable.heart2);
            botLife = 3;
            playerLife = 3;
            tieCounter = 0;
            tie.setText("Döntetlenek száma: " + tieCounter);
        }

        public void init() {
            botLife1 = findViewById(R.id.botLife1);
            botLife2 = findViewById(R.id.botLife2);
            botLife3 = findViewById(R.id.botLife3);
            playerLife1 = findViewById(R.id.playerLife1);
            playerLife2 = findViewById(R.id.playerLife2);
            playerLife3 = findViewById(R.id.playerLife3);
            tie = findViewById(R.id.tie);
            ImageViewBot = findViewById(R.id.ImageViewBot);
            ImageViewPlayer = findViewById(R.id.ImageViewPlayer);
            rock = findViewById(R.id.rock);
            paper = findViewById(R.id.paper);
            scissors = findViewById(R.id.scissors);
            random = new Random();
        }
    }
