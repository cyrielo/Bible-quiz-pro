package com.cyrielo.Bible_quiz_pro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author cyrielo <cyrielo911@gmail.com>
 * @version 1.0
 */
public class QuizQuestionAndAnswers extends AbstractQuiz implements View.OnClickListener {
    TextView activity_title;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        int selectedLevel = getIntent().getExtras().getInt("SelectedLevel");
        this.init(selectedLevel);

        this.questionNumber = (TextView) findViewById(R.id.questionNumber);
        this.questionText = (TextView) findViewById(R.id.questionText);

        this.optionA = (Button) findViewById(R.id.optionA);
        this.optionB = (Button) findViewById(R.id.optionB);
        this.optionC = (Button) findViewById(R.id.optionC);
        this.optionD = (Button) findViewById(R.id.optionD);


        this.activity_title = (TextView) findViewById(R.id.AppTitle);
        this.activity_title.setText(this.levelName + " quiz questions");
        this.optionA.setOnClickListener(this);
        this.optionB.setOnClickListener(this);
        this.optionC.setOnClickListener(this);
        this.optionD.setOnClickListener(this);

        if (savedInstanceState != null) {
            this.questionId = savedInstanceState.getInt(this.saveQuestionId);
            this.wrongAnswerCount = savedInstanceState.getInt(this.saveWrongAnswerCount);
            this.correctAnswerCount = savedInstanceState.getInt(this.saveCorrectAnswerCount);
            this.randomQuestionKeys = savedInstanceState.getIntArray(this.saveRandomQuestionKeys);
        }
        this.setNextQuestion();
    }

    public void onClick(View v) {

        Button chosenButton = (Button) findViewById(v.getId());
        String value = chosenButton.getText().toString();
        this.checkAnswer(value);
    }

    public void init(int selectedLevel) {
        switch (selectedLevel) {
            case R.string.first_activity:
                this.Rookie();
                break;
            case R.string.second_activity:
                this.Enthusiast();
                break;
            case R.string.third_activity:
                this.Intermediate();
                break;
            case R.string.fourth_activity:
                this.Pro();
                break;
            case R.string.fifth_activity:
                this.Expert();
                break;
            case R.string.sixth_activity:
                this.Genius();
                break;
            case R.string.seventh_activity:
                this.Master();
                break;
            case R.string.eighth_activity:
                this.GrandMaster();
                break;
            case R.string.ninth_activity:
                this.Legend();
                break;
            case R.string.tenth_activity:
                this.OutOfThisWorld();
                break;
        }
    }

    public void Rookie() {
        String[] questions =
                {
                        "Who is the first man who ever lived?",
                        "Who was swallowed by a very large fish?",
                        "Who is the person God used to lead the Israelites out of Egypt",
                        "Who was the person who killed Goliath",
                        "Who was the first King of Israel?",
                        "What occupation did Jesus have prior to his ministry",
                        "What is the name of the city in which Jesus was born?",
                        "What is the name of the sea upon which jesus walked",
                        "What is the name of the river in which John the baptist baptized people?",
                        "What is the name of Andrew's brother? (Both were disciples)",
                        "What was the name of Jesus Mother?",
                        "What was the name of the garden where Adam and Eve lived?",
                        "With what food did jesus feed 5,000 people",
                        "What method did the romans used to kill jesus?"
                };

        String[] answers =
                {
                        "Adam",
                        "Jonah",
                        "Moses",
                        "David",
                        "Saul",
                        "Carpenter",
                        "Bethlehem",
                        "Sea of Galilee",
                        "Jordan",
                        "Peter",
                        "Mary",
                        "Garden of Eden",
                        "Loaves of bread and fishes",
                        "Crucifixion",
                        //

                };
        String[][] options =
                {
                        {
                                "Methuselah",
                                "Abraham",
                                "Moses",
                                "Adam"
                        },
                        {
                                "Jesus",
                                "Jonah",
                                "Samson",
                                "Peter"
                        },
                        {
                                "Aaron",
                                "Abraham",
                                "Moses",
                                "Jeremiah"
                        },
                        {
                                "David",
                                "Saul",
                                "Solomon",
                                "Jonathan"
                        },
                        {"David",
                                "Saul",
                                "Solomon",
                                "Moses"
                        },
                        {
                                "Toymaker",
                                "Fisherman",
                                "Vineyard keeper",
                                "Carpenter"
                        },
                        {
                                "Jerusalem",
                                "Bethlehem",
                                "Galilee",
                                "Nazareth"
                        },
                        {
                                "Sea of Galilee",
                                "Dead Sea",
                                "Red Sea",
                                "Mediterranean Sea"
                        },
                        {
                                "Euphrates",
                                "Nile",
                                "Jordan",
                                "Tigris"
                        },
                        {
                                "Peter",
                                "John",
                                "James",
                                "Adam"
                        },
                        //////////////
                        {
                                "Mary",
                                "Martha",
                                "Zipporah",
                                "Sarah"
                        },
                        {
                                "Land of Nod",
                                "Garden of Eden",
                                "Bethlehem",
                                "Garden of valley"
                        },
                        {
                                "Wine",
                                "Loaves of bread and wine",
                                "Loaves of bread and fishes",
                                "Water"
                        },
                        {
                                "Stoned",
                                "Cremation",
                                "Crucifixion",
                                "Hanged"
                        }

                };
        this.questions = questions;
        this.answers = answers;
        this.options = options;

        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.first_activity);
        this.nextLevelName = getResources().getString(R.string.second_activity);
        this.nextLevelId = R.string.second_activity;
    }

    public void Enthusiast() {

        String[] questions =
                {
                        "Who was the father of Isaac?",
                        "Who was the father of Rehoboam?",
                        "Who was the father of Methuselah?",
                        "Who killed John the Baptist?",
                        "Who was the first person killed because he believed in Christ?",
                        "Where was Saul going when he saw Jesus?",
                        "Where did Jesus spend the majority of his life on earth?",
                        "What Psalm begins, \"The Lord is my shepherd?\"",
                        "What was Paul's occupation as he traveled as a missionary?",
                        "What is the name of the Island upon which Barnabas lived?",
                        "When he was approached by Jesus, who  said, \"What have you to do with me, Jesus, Son of the" +
                                " Most High God? I adjure you by God, do not torment me.\"?",
                        "Which bird does Jesus say we have more value than?",
                        "Which two sisters married Jacob?",
                        "Into which land did God send Abraham to sacrifice his special son, Isaac?"


                };
        String[] answers =
                {
                        "Abraham",
                        "Solomon",
                        "Enoch",
                        "Herod",
                        "Stephen",
                        "Damascus",
                        "Nazareth",
                        "Psalm 23",
                        "Tent maker",
                        "Cyprus",
                        "Legion",
                        "Sparrow",
                        "Rachel and Leah",
                        "Moriah"
                };
        String[][] options =
                {
                        {
                                "Abraham",
                                "Jacob",
                                "Esau",
                                "Peleg"
                        },
                        {
                                "David",
                                "Nimrod",
                                "Abimelech",
                                "Solomon"
                        },
                        {
                                "Elijah",
                                "Enoch",
                                "Seth",
                                "Jared"
                        },
                        {
                                "Caesar",
                                "Pilate",
                                "Herod",
                                "Caiaphas"
                        },
                        {"Peter",
                                "John",
                                "Barnabas",
                                "Stephen"
                        },
                        {
                                "Damascus",
                                "Greece",
                                "Rome",
                                "Jerusalem"
                        },
                        {
                                "Jerusalem",
                                "Nazareth",
                                "Mount of Olives",
                                "Egypt"
                        },
                        {
                                "Psalm 91",
                                "Psalm 1",
                                "Psalm 104",
                                "Psalm 23"
                        },
                        {
                                "Shepherd",
                                "Seller of purple",
                                "Tent maker",
                                "Scribe"
                        },
                        {
                                "Greece",
                                "Cyprus",
                                "Rhodes",
                                "Easter Island"
                        },
                        {
                                "Legion",
                                "Terah",
                                "Reuben",
                                "Belshazzar "
                        },
                        {
                                "Eagle",
                                "Vulture",
                                "sparrow",
                                "Dove"
                        },
                        {
                                "Dorcas and Leah ",
                                "Mariam and Rachael",
                                "Rachel and Leah",
                                "Sarai and Hannah"
                        },
                        {
                                "Canaan",
                                "Macedonia",
                                "Cyprus",
                                "Moriah"
                        }


                };
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.second_activity);
        this.nextLevelName = getResources().getString(R.string.third_activity);
        this.nextLevelId = R.string.third_activity;
    }

    public void Intermediate() {
        String[] questions =
                {
                        "Who was the wife of Moses?",
                        "Who was the second wife of Abraham?",
                        "How many chapters are contained in the Sermon on the Mount?",
                        "How many times did Israel march around Jericho?",
                        "How long is a cubit?",
                        "Where did Cain go after he had killed Abel?",
                        "Who was the son of Kish?",
                        "Where did Rahab live?",
                        "Where did Dorcas live?",
                        "Where is the \"Street called Straight\"?"
                };

        String[] answers =
                {
                        "Zipporah",
                        "Keturah",
                        "3",
                        "13",
                        "approx. 18 inches",
                        "Land of Nod",
                        "King Saul",
                        "Jericho",
                        "Joppa",
                        "Damascus"
                };
        String[][] options =
                {
                        {
                                "Elisheba",
                                "Rebecca",
                                "Miriam",
                                "Zipporah"
                        },
                        {
                                "Esther",
                                "Keturah",
                                "Hagar",
                                "Lydia"
                        },
                        {
                                "1",
                                "2",
                                "3",
                                "7"
                        },
                        {
                                "13",
                                "7",
                                "70",
                                "12"
                        },
                        {"approx. 12 inches",
                                "22mm",
                                "approx. 18 inches",
                                "approx. 36 inches"
                        },
                        {
                                "Garden of Eden",
                                "Land of Nod",
                                "Caves of Qumran",
                                "Mt. Ararat"
                        },
                        {
                                "Noah",
                                "Apostle Paul",
                                "Abraham",
                                "King Saul"
                        },
                        {
                                "Jericho",
                                "Jerusalem",
                                "Nineveh",
                                "Ai"
                        },
                        {
                                "Bethel",
                                "Joppa",
                                "Caesarea",
                                "Antioch"
                        },
                        {
                                "Jerusalem",
                                "Rome",
                                "Babylon",
                                "Damascus"
                        }
                };
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.third_activity);
        this.nextLevelName = getResources().getString(R.string.fourth_activity);
        this.nextLevelId = R.string.fourth_activity;
    }

    public void Pro() {
        String[] questions =
                {
                        "Who carried the cross for Christ?",
                        "How many companions did the Philistines give to Samson at the feast in Timnah? ",
                        "How old was Anna the prophetess when she saw Jesus? ",
                        "What did the Queen of Sheba give to Solomon?",
                        "How many books are there in the Old Testament?",
                        "How many rivers did the river in Eden split into once it left the garden?",
                        "What did Joseph want to do when he discovered Mary was pregnant?",
                        "What color was the High Priest’s robe? ",
                        "What did Boaz say Naomi was selling?",
                        "In the parable of the debtors, one owed 500 denarii (pence), but how much did the other one owe",
                        "How much of Elijah’s spirit did Elisha receive?",
                        "What was unusual about the 700  Benjamite soldiers who could sling a stone and hit their target every time?",
                        "What relation was Annas to Caiaphas?",
                        "What should you not \"throw before swine\"?",
                        "When in prison at what time did Paul and Silas pray and sing to God?",
                        "What did Daniel and his three friends eat instead of the king's meat and drink?",
                        "What is the name of Jesus' cousin,  born six months before him?",
                        "In which city did King Herod live at the time of Jesus' birth?",
                        "How many plagues did God send on Egypt?",
                        "For how many pieces of silver did Judas betray Christ?",
                        "For how many days did Jesus appear to his disciples after his resurrection?",
                        "How many churches of Asia Minor were listed in Revelation?"
                };

        String[] answers =
                {
                        "Simon of Cyrene",
                        "30",
                        "84",
                        "(120 talents of) gold, spices, and precious stones",
                        "39",
                        "4",
                        "Divorce her",
                        "Blue",
                        "A parcel of land",
                        "50",
                        "Double portion",
                        "They were all left-handed",
                        "Father-in-law",
                        "Pearls",
                        "Midnight",
                        "Pulses and water",
                        "John",
                        "Jerusalem",
                        "10",
                        "30",
                        "40",
                        "7"
                };
        String[][] options =
                {
                        {
                                "Philip",
                                "Simon of Cyrene",
                                "Ahab",
                                "Micah"
                        },
                        {
                                "30",
                                "31",
                                "32",
                                "33"
                        },
                        {
                                "83",
                                "84",
                                "88",
                                "92"
                        },
                        {
                                "(124 talents of) gold, spices, and precious stones",
                                "(120 talents of) gold, spices, and precious stones",
                                "(18 talents of) gold, spices, and precious stones",
                                "(221 talents of) gold, spices, and precious stones"
                        },
                        {"37",
                                "38",
                                "39",
                                "40"
                        },
                        {
                                "4",
                                "3",
                                "6",
                                "8"
                        },
                        {
                                "Throw a party",
                                "Divorce her",
                                "Run away",
                                "None of the above"
                        },
                        {
                                "Blue",
                                "White",
                                "green",
                                "red"
                        },
                        {
                                "A parcel of land",
                                "Gold",
                                "Her child",
                                "Food"
                        },
                        {
                                "70",
                                "50",
                                "45",
                                "80"
                        },
                        {
                                "Little",
                                "Single portion",
                                "Wholesome",
                                "Double portion"
                        },
                        {
                                "They were all left-handed",
                                "They all looked alike",
                                "They had no shoes",
                                "None of the above"
                        },
                        {
                                "Brother",
                                "Uncle",
                                "Cousins",
                                "Father-in-law"
                        },

                        {"Pebbles",
                                "Stones",
                                "Pearls",
                                "Stick"
                        },
                        {
                                "Morning",
                                "Afternoon",
                                "evening",
                                "Midnight"
                        },
                        {
                                "Bread",
                                "Wine and bread",
                                "Pulses and water",
                                "Nothing"
                        },
                        {
                                "John",
                                "Peter",
                                "Paul",
                                "Michael"
                        },
                        {
                                "Jerusalem",
                                "Rome",
                                "Babylon",
                                "Bethlehem"
                        },
                        {
                                "4",
                                "8",
                                "10",
                                "12"
                        },
                        {
                                "20",
                                "30",
                                "40",
                                "50"
                        },
                        {
                                "30",
                                "7",
                                "40",
                                "11"
                        },
                        {
                                "7",
                                "8",
                                "9",
                                "10"
                        },

                };
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.fourth_activity);
       /* this.nextLevelName  = getResources().getString( R.string.fifth_activity );
        this.nextLevelId    = R.string.fifth_activity;*/
        this.nextLevelName = "End";
        this.nextLevelId = 0;
    }

    public void Expert() {
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.fifth_activity);
        this.nextLevelName = getResources().getString(R.string.sixth_activity);
        this.nextLevelId = R.string.sixth_activity;
    }

    public void Genius() {
        String[] questions =
                {
                        "Who was the son of Eleazar, the son of Aaron?",
                        "Who was the son of Omri, the king of Israel?",
                        "Who was the husband of Naomi from the book of Ruth?",
                        "How many letters are in the longest name in the Bible?",
                        "Who killed Sisera?",
                        "How wide was Noah's ark?",
                        "How wide was the Ark of the Covenant?",
                        "What was the name of Elisha's servant?",
                        "What was the name of Paul's famous teacher?",
                        "What judge of Israel was born in Bethlehem?"
                };

        String[] answers =
                {
                        "Phinehas",
                        "Ahab",
                        "Elimelech",
                        "18",
                        "Jael",
                        "50 cubits",
                        "1.5 cubits",
                        "Gehazi",
                        "Gamaliel",
                        "Ibzan"
                };
        String[][] options =
                {
                        {
                                "Putiel",
                                "Korah",
                                "Phinehas",
                                "Izhar"
                        },
                        {
                                "Ahab",
                                "Joram",
                                "Zimri",
                                "Ginath"
                        },
                        {
                                "Boaz",
                                "Elkanah",
                                "Obed",
                                "Elimelech"
                        },
                        {
                                "16",
                                "18",
                                "22",
                                "25"
                        },
                        {"David",
                                "Ahab",
                                "Saul",
                                "Jael"
                        },
                        {
                                "35 cubits",
                                "50 cubits",
                                "75 cubits",
                                "90 cubits"
                        },
                        {
                                "1.5 cubits",
                                "2 cubits",
                                "3 cubits",
                                "1 cubit"
                        },
                        {
                                "Jehoram",
                                "Shaphat",
                                "Gehazi",
                                "Hazael"
                        },
                        {
                                "Justus",
                                "Gamaliel",
                                "Caiaphas",
                                "Socrates"
                        },
                        {
                                "David",
                                "Ibzan",
                                "Deborah",
                                "Gideon"
                        }
                };
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.sixth_activity);
        this.nextLevelName = getResources().getString(R.string.seventh_activity);
        this.nextLevelId = R.string.seventh_activity;
    }

    public void Master() {
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.seventh_activity);
        this.nextLevelName = getResources().getString(R.string.eighth_activity);
        this.nextLevelId = R.string.eighth_activity;
    }

    public void GrandMaster() {
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.eighth_activity);
        this.nextLevelName = getResources().getString(R.string.ninth_activity);
        this.nextLevelId = R.string.ninth_activity;
    }

    public void Legend() {
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.ninth_activity);
        this.nextLevelName = getResources().getString(R.string.tenth_activity);
        this.nextLevelId = R.string.tenth_activity;
    }

    public void OutOfThisWorld() {
        this.randomQuestionKeys = this.generateRandomKeys(this.questions.length);
        this.levelName = getResources().getString(R.string.tenth_activity);
        this.nextLevelName = "End";
        this.nextLevelId = 0;
    }
}
