using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Globalization;
using System.Diagnostics;

namespace Patch
{
    public partial class Form : System.Windows.Forms.Form
    {
        public Form()
        {
            InitializeComponent();
        }


        public static String his = "its";
        public static String him = "it";
        public static String he = "it";
        public static String gender = "panxermalecomeagain";
        public static String colour = "white";
        public static String pName = Properties.Settings.Default.Name;

        public void TermInit()
        {
            if (Properties.Settings.Default.Gender == false)
            {
                his = "her";
                him = "her";
                he = "she";
                gender = "female";
            }
            else
            {
                his = "his";
                him = "him";
                he = "he";
                gender = "male";
            }

            pName = Properties.Settings.Default.Name;

            switch (Properties.Settings.Default.Colour)
            {
                case 0:
                    colour = "White";
                    break;
                case 1:
                    colour = "Blue";
                    break;
                case 2:
                    colour = "Yellow";
                    break;
                case 3:
                    colour = "Red";
                    break;
                case 4:
                    colour = "Green";
                    break;
                case 5:
                    colour = "Purple";
                    break;
            }
        }

        public void needsUpdate()
        {
            //initialize variables
            double timeDifference;
            timeDifference = (DateTime.Now - Properties.Settings.Default.LastCheck).TotalHours;
            double hungerDifference = timeDifference * 5;
            double funDifference = timeDifference * 6;
            double hygieneDifference = timeDifference * 4;

            //control age
            int sAge = (int)(Math.Round((DateTime.Now - Properties.Settings.Default.BirthDate).TotalDays));
            Properties.Settings.Default.Age = sAge;

            if (Properties.Settings.Default.checkDay < Properties.Settings.Default.Age)
            {
                Random rnd = new Random();
                
                Properties.Settings.Default.checkDay += 1;
                if (Properties.Settings.Default.Weight > 240)
                {
                    int init = rnd.Next(2);
                    Properties.Settings.Default.Weight -= 1 + init;
                }
            }
            

            //control hunger
            Properties.Settings.Default.Hunger -= hungerDifference;
            while (Properties.Settings.Default.Hunger < 0)
            {
                Properties.Settings.Default.Hunger += 5;
                Properties.Settings.Default.Weight -= 20;
            }

            //control fun
            Properties.Settings.Default.Fun -= funDifference;
            if (Properties.Settings.Default.Fun < 0)
            {
                Properties.Settings.Default.Fun = 0;
            }

            //lower sickness if sick
            if (Properties.Settings.Default.Sickness > 4)
            {
                Properties.Settings.Default.Sickness -= (int)(timeDifference * 5);
            }
            else
            {
                Properties.Settings.Default.Sickness = 0;
            }

            //control hygiene and sickness if hygiene depleted.
            Properties.Settings.Default.Hygiene -= hygieneDifference;
            while (Properties.Settings.Default.Hygiene < 0)
            {
                Properties.Settings.Default.Hygiene += 4;
                Properties.Settings.Default.Sickness += 20;
            }

            //show gravestone if patcho died
            if (Properties.Settings.Default.LifeState == 6)
            {
                lblHunger.Text = "0";
                lblFun.Text = "0";
                lblHygiene.Text = "0";
                btnClean.Visible = false;
                btnFeed.Visible = false;
                btnPlay.Visible = false;
                btnDetail.Text = "Restart";
                lblInfo.Text = pName + "'s still dead.";
            }
            else
            {
                //control lifestate
                ageUp();

                //died of sickness
                if (Properties.Settings.Default.Sickness > 100)
                {
                    lblHunger.Text = "0";
                    lblFun.Text = "0";
                    lblHygiene.Text = "0";
                    btnClean.Visible = false;
                    btnFeed.Visible = false;
                    btnPlay.Visible = false;
                    btnDetail.Text = "Restart";
                    lblInfo.Text = pName + " died a slow and horrible dead to a preventable disease.\nGood job.";
                    Properties.Settings.Default.LifeState = 6;
                }
                //died of overweight
                if (Properties.Settings.Default.Weight > 300)
                {
                    lblHunger.Text = "0";
                    lblFun.Text = "0";
                    lblHygiene.Text = "0";
                    btnClean.Visible = false;
                    btnFeed.Visible = false;
                    btnPlay.Visible = false;
                    btnDetail.Text = "Restart";
                    lblInfo.Text = pName + " died to a heart attack.";
                    Properties.Settings.Default.LifeState = 6;
                }
                //died of malnourishment
                if (Properties.Settings.Default.LifeState == 1)
                {
                    if (Properties.Settings.Default.Weight < 20)
                    {
                        lblHunger.Text = "0";
                        lblFun.Text = "0";
                        lblHygiene.Text = "0";
                        btnClean.Visible = false;
                        btnFeed.Visible = false;
                        btnPlay.Visible = false;
                        btnDetail.Text = "Restart";
                        lblInfo.Text = pName + " starved to death. \nGood job.";
                        Properties.Settings.Default.LifeState = 6;
                    }
                }
                else if (Properties.Settings.Default.LifeState == 2)
                {
                    if (Properties.Settings.Default.Weight < 50)
                    {
                        lblHunger.Text = "0";
                        lblFun.Text = "0";
                        lblHygiene.Text = "0";
                        btnClean.Visible = false;
                        btnFeed.Visible = false;
                        btnPlay.Visible = false;
                        btnDetail.Text = "Restart";
                        lblInfo.Text = pName + " starved to death. \nGood job.";
                        Properties.Settings.Default.LifeState = 6;
                    }
                }
                else
                {
                    if (Properties.Settings.Default.Weight < 100)
                    {
                        lblHunger.Text = "0";
                        lblFun.Text = "0";
                        lblHygiene.Text = "0";
                        btnClean.Visible = false;
                        btnFeed.Visible = false;
                        btnPlay.Visible = false;
                        btnDetail.Text = "Restart";
                        lblInfo.Text = pName + " starved to death. \nGood job.";
                        Properties.Settings.Default.LifeState = 6;
                    }
                }
            }

            
            

            //write hunger fun and hygiene down
            lblHunger.Text = Math.Round(Properties.Settings.Default.Hunger).ToString();
            lblFun.Text = Math.Round(Properties.Settings.Default.Fun).ToString();
            lblHygiene.Text = Math.Round(Properties.Settings.Default.Hygiene).ToString();

            //update the last check and save settings.
            Properties.Settings.Default.LastCheck = DateTime.Now;
            Properties.Settings.Default.Save();

            Debug.WriteLine(Properties.Settings.Default.Hunger);
            Debug.WriteLine(Properties.Settings.Default.Fun);
            Debug.WriteLine(Properties.Settings.Default.Hygiene);
            Debug.WriteLine(Properties.Settings.Default.LastCheck);
            Debug.WriteLine(timeDifference);
        }

        //FUNCTION
        //control lifestate
        public void ageUp()
        {
            Random rnd = new Random();
            if (Properties.Settings.Default.Age > Properties.Settings.Default.MaxAge)
            {
                Properties.Settings.Default.LifeState = 6;
                lblInfo.Text = pName + " died a peaceful death after a long and fulfilling life.";
            }
            else if (Properties.Settings.Default.Age > 11)
            {
                //adult to elder
                if (Properties.Settings.Default.LifeState == 4)
                {
                    Properties.Settings.Default.LifeState = 5;
                    switch (Properties.Settings.Default.Nature)
                    {
                        case 7:
                            Properties.Settings.Default.Nature = 13;
                            break;
                        case 8:
                            Properties.Settings.Default.Nature = 14;
                            break;
                        case 9:
                            Properties.Settings.Default.Nature = 15;
                            break;
                        case 10:
                            int init = rnd.Next(2);
                            if (init == 0)
                            {
                                Properties.Settings.Default.Nature = 16;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 17;
                            }
                            break;
                        case 11:
                            Properties.Settings.Default.Nature = 18;
                            break;
                        case 12:
                            Properties.Settings.Default.Nature = 19;
                            break;
                        default:
                            Properties.Settings.Default.Nature = 19;
                            break;
                    }
                    Properties.Settings.Default.Lazyness = 0;
                }
            }
            else if (Properties.Settings.Default.Age > 7)
            {
                //teen to adult
                if (Properties.Settings.Default.LifeState == 3)
                {
                    Properties.Settings.Default.LifeState = 4;
                    switch (Properties.Settings.Default.Nature)
                    {
                        case 3:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 8;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 7;
                            }
                            break;
                        case 4:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 10;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 9;
                            }
                            break;
                        case 5:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 12;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 11;
                            }
                            break;
                        case 6:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 10;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 12;
                            }
                            break;
                        default:
                            Properties.Settings.Default.Nature = 12;
                            break;
                    }
                    Properties.Settings.Default.Lazyness = 0;
                }
            }
            else if (Properties.Settings.Default.Age > 4)
            {
                //child to teen
                if (Properties.Settings.Default.LifeState == 2)
                {
                    Properties.Settings.Default.Weight += 50;
                    Properties.Settings.Default.LifeState = 3;
                    switch (Properties.Settings.Default.Nature)
                    {
                        case 1:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 4;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 3;
                            }
                            break;
                        case 2:
                            if (Properties.Settings.Default.Lazyness < 100)
                            {
                                Properties.Settings.Default.Nature = 6;
                            }
                            else
                            {
                                Properties.Settings.Default.Nature = 5;
                            }
                            break;
                        default:
                            Properties.Settings.Default.Nature = 5;
                            break;
                    }
                    Properties.Settings.Default.Lazyness = 0;
                }
            }
            else if (Properties.Settings.Default.Age > 1)
            {
                //baby to child
                if (Properties.Settings.Default.LifeState == 1)
                {
                    Properties.Settings.Default.Weight += 50;
                    Properties.Settings.Default.LifeState = 2;
                    int init = rnd.Next(2);
                    if (init == 0)
                    {
                        Properties.Settings.Default.Nature = 1;
                    }
                    else
                    {
                        Properties.Settings.Default.Nature = 2;
                    }
                    Properties.Settings.Default.Lazyness = 0;
                }
            }
        }

        //FUNCTION
        //Initialize Patcho
        public void InitializePatcho()
        {
            /*  
             * Lifestate:                           * Colour:
             *  0   Naming                              0 White                  
             *  1   Baby                                1 Blue
             *  2   Child                               2 Yellow
             *  3   Teen                                3 Red
             *  4   Adult                               4 Green
             *  5   Elder                               5 Purple
             *  6   Dead  
             *  7   New Game                  
             *  
             * Nature:                              * Gender:
             *  0  Baby             - to 1 or 2         0 Female
             *  1  Smart child      - to 3 or 4         1 Male
             *  2  Bold child       - to 5 or 6
             *  3  Bum teen         - to 7 or 8
             *  4  Student teen     - to 9 or 10
             *  5  Ambitious teen   - to 11 or 12
             *  6  Edgelord teen    - to 12 or 10
             *  7  Neet adult       - to 13
             *  8  Philospher adult - to 14
             *  9  Scientist adult  - to 15
             *  10 Evil adult       - to 16 or 17
             *  11 Hero adult       - to 18
             *  12 Business adult   - to 19
             *  13 Dement elder
             *  14 Wise elder
             *  15 Cyborg elder
             *  16 Overlord elder
             *  17 Cranky elder
             *  18 Retired elder
             *  19 Old elder
             */
            Properties.Settings.Default.LifeState = 0;

            Random rnd = new Random();
            int init = rnd.Next(2);
            if (init == 0)
            {
                Properties.Settings.Default.Gender = false;
            }
            else
            {
                Properties.Settings.Default.Gender = true;
            }
            init = rnd.Next(50,100);
            Properties.Settings.Default.Weight = init;

            init = rnd.Next(6);
            Properties.Settings.Default.Colour = init;

            init = rnd.Next(14,20);
            Properties.Settings.Default.MaxAge = init;

            Properties.Settings.Default.BirthDate = DateTime.Now;
            Properties.Settings.Default.LastCheck = DateTime.Now;
            Properties.Settings.Default.Age = 0;
            Properties.Settings.Default.Nature = 0;
            Properties.Settings.Default.Sickness = 0;
            Properties.Settings.Default.Lazyness = 0;
            Properties.Settings.Default.Hunger = 50;
            Properties.Settings.Default.Fun = 50;
            Properties.Settings.Default.Hygiene = 50;
            Properties.Settings.Default.checkDay = 0;
            TermInit();
            lblInfo.Text = "It's a " + gender + " " + colour + " baby patcho! \nHow wil you name " + him + "?";
            btnClean.Visible = false;
            btnFeed.Visible = false;
            btnPlay.Visible = false;
            textBox.Visible = true;
            btnDetail.Text = "OK";
        }

        private void Form_Load(object sender, EventArgs e)
        {
            TermInit();

            if (Properties.Settings.Default.LifeState == 7)
            {
                InitializePatcho();
            }
            if (Properties.Settings.Default.LifeState == 0)
            {
                
            }
            if (Properties.Settings.Default.LifeState == 1)
            {

            }
            if (Properties.Settings.Default.LifeState >= 1)
            {
                needsUpdate();
                getLine();
            }
            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnDetail_Click(object sender, EventArgs e)
        {
            if (Properties.Settings.Default.LifeState == 0)
            {
                string sName = textBox.Text;
                bool allLetters = sName.All(c => Char.IsLetter(c));
                if (allLetters == false)
                {
                    if (sName.Length > 20)
                    {
                        lblInfo.Text = "Please don't.";
                        return;
                    }
                    else
                    {
                        lblInfo.Text = "Please don't use any edgy characters or numbers \nin your Patcho's name, " + he + "'ll get bullied.";
                        return;
                    }
                }
                if (sName.Length > 10)
                {
                    if (sName.Length > 20)
                    {
                        lblInfo.Text = "Please don't.";
                        return;
                    }
                    else
                    {
                        lblInfo.Text = "Please keep your patcho's name under 10 characters,\notherwise the patcho can't understand " + his + " own name,\nand that would be sad.";
                        return;
                    }
                    
                }
                sName = CultureInfo.CurrentCulture.TextInfo.ToTitleCase(sName.ToLower());
                Properties.Settings.Default.Name = sName;
                btnClean.Visible = true;
                btnFeed.Visible = true;
                btnPlay.Visible = true;
                btnDetail.Text = "Details";

                Properties.Settings.Default.LifeState = 1;
                TermInit();
                lblInfo.Text = pName + " marvels at the wonders of a new world!";
                textBox.Visible = false;
                needsUpdate();
            }
            else if (Properties.Settings.Default.LifeState == 6)
            {
                InitializePatcho();
            }
            else
            {
                if (picPatch.Visible == true)
                {
                    picPatch.Visible = false;
                    lblDetail.Visible = true;
                    lblDetails2.Visible = true;
                    lblInfo.Visible = false;
                    btnClean.Visible = false;
                    btnFeed.Visible = false;
                    btnPlay.Visible = false;
                    btnDetail.Text = "Back";

                    lblDetail.Text = "Name: \nGender: \nColour: \nWeight: \nBirthday: \nAge:";
                    lblDetail.Text += "\n\n\n\n";

                    TermInit();

                    //Nature
                    switch (Properties.Settings.Default.Nature)
                    {
                        case 0:
                            //baby
                            lblDetail.Text += "Acts like a baby.";
                            break;
                        case 1:
                            //smart child
                            lblDetail.Text += "Might be gifted. Who knows.";
                            break;
                        case 2:
                            //bold child
                            lblDetail.Text += "Likes to do stupid things.";
                            break;
                        case 3:
                            //bum teen
                            lblDetail.Text += "Likes to laze around.";
                            break;
                        case 4:
                            //student teen
                            lblDetail.Text += "Busy studying so " + he + " can enter a\nprestigious college.";
                            break;
                        case 5:
                            //ambitious teen
                            lblDetail.Text += "Aims for the stars☆!";
                            break;
                        case 6:
                            //edgelord teen
                            lblDetail.Text += "Grown up to be a true edgelord.";
                            break;
                        case 7:
                            //neet adult
                            lblDetail.Text += "Spends " + his + " days watching anime and hugging\npillows with cartoons drawn on them.";
                            break;
                        case 8:
                            //philosopher adult
                            lblDetail.Text += "Says deep and thought-provoking things that, often \nconfuse both others and himself.";
                            break;
                        case 9:
                            //scientist adult
                            lblDetail.Text += "Really smart. Likes to do science-y stuff\nthat's too difficult for you to understand.";
                            break;
                        case 10:
                            //evil adult
                            lblDetail.Text += "Secretely plots to take over the world.";
                            break;
                        case 11:
                            //hero adult
                            lblDetail.Text += "Became a shining example for Patcho's both old and young.";
                            break;
                        case 12:
                            //business adult
                            lblDetail.Text += "Works a stable 9 to 5 job with an average income.";
                            break;
                        case 13:
                            //dement elder
                            lblDetail.Text += "Forgets stuff.";
                            break;
                        case 14:
                            //wise elder
                            lblDetail.Text += "Very old and wise. \nGives swords to young heroes.";
                            break;
                        case 15:
                            //cyborg elder
                            lblDetail.Text += "Underwent heavy cybernetic surgery in attempt \nto prolong " + his + " life.";
                            break;
                        case 16:
                            //overlord elder
                            lblDetail.Text += "Rules with an iron fist after \nsuccessfully taking over the world.";
                            break;
                        case 17:
                            //cranky elder
                            lblDetail.Text += "Spends " + his + " final days screaming at children \nand throwing fits.";
                            break;
                        case 18:
                            //retired elder
                            lblDetail.Text += "Often thinks back to his younger years,\nand smiles.";
                            break;
                        case 19:
                            //old elder
                            lblDetail.Text += "After having crossed everything on "+ his +" bucket list,\n" + pName + " is peacefully waiting for "+his+" time.";
                            break;
                        default:
                            lblDetail.Text += "You did something to break the game, \ndidn't you?";
                            break;
                    }

                    //Name
                    lblDetails2.Text = Properties.Settings.Default.Name;

                    //Gender
                    if (Properties.Settings.Default.Gender == true)
                    {
                        lblDetails2.Text += "\nMale";
                    }
                    else
                    {
                        lblDetails2.Text += "\nFemale";
                    }

                    //Colour
                    lblDetails2.Text += "\n" + colour;

                    //Weight
                    string sWeight;
                    sWeight = Properties.Settings.Default.Weight.ToString();
                    lblDetails2.Text += "\n" + sWeight + " grams";

                    //Birthday
                    DateTime sBirthday = Properties.Settings.Default.BirthDate;
                    sBirthday = sBirthday.Date;
                    lblDetails2.Text += "\n" + sBirthday.ToString("d");

                    //Age
                    string sAge;
                    sAge = Properties.Settings.Default.Age.ToString();
                    lblDetails2.Text += "\n" + sAge + " days";

                    switch (Properties.Settings.Default.LifeState)
                    {
                        case 0:
                            lblDetails2.Text += "\nBaby";
                            break;
                        case 1:
                            lblDetails2.Text += "\nBaby";
                            break;
                        case 2:
                            lblDetails2.Text += "\nChild";
                            break;
                        case 3:
                            lblDetails2.Text += "\nTeen";
                            break;
                        case 4:
                            lblDetails2.Text += "\nAdult";
                            break;
                        case 5:
                            lblDetails2.Text += "\nElder";
                            break;
                        case 6:
                            lblDetails2.Text += "\nDead";
                            break;
                    }
                    

                }
                else
                {
                    picPatch.Visible = true;
                    lblDetail.Visible = false;
                    lblDetails2.Visible = false;
                    lblInfo.Visible = true;
                    btnClean.Visible = true;
                    btnFeed.Visible = true;
                    btnPlay.Visible = true;
                    btnDetail.Text = "Details";
                    getLine();
                }
            }
                
            
        }

        public void getLine()
        {
            if (Properties.Settings.Default.LifeState >= 1 && Properties.Settings.Default.LifeState < 6)
            {
                string Line = "";
                Random rnd = new Random();
                int pickOne = rnd.Next(4);

                switch (Properties.Settings.Default.Nature)
                {
                    //baby
                    case 0:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " tries to put " + his + " toes into " + his + " mouth, \nbut remembers " + he + " doesn't have any toes.";
                                break;
                            case 1:
                                Line = pName + " does something so silly that you wish you \nhad filmed and uploaded it for easy facebook likes.";
                                break;
                            case 2:
                                Line = pName + " is doing baby stuff.";
                                break;
                            case 3:
                                Line = pName + " is rolling around happily.";
                                break;
                        }

                        break;
                    //smart child
                    case 1:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " says something really witty for " + his + " age.";
                                break;
                            case 1:
                                Line = pName + " redraws the Mona Lisa with chalk.";
                                break;
                            case 2:
                                Line = pName + " makes a statement on the current \npolitic system.";
                                break;
                            case 3:
                                Line = pName + " drinks "+his+" coffee black.";
                                break;
                        }
                        break;
                    //bold child
                    case 2:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " runs around aimlessly.";
                                break;
                            case 1:
                                Line = pName + " hurts " + him + "self as " + he + " makes a triple summersault.";
                                break;
                            case 2:
                                Line = pName + " is brimming with energy.";
                                break;
                            case 3:
                                Line = pName + " is rolling around happily.";
                                break;
                        }
                        break;
                    //bum teen
                    case 3:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " says " + he + "'ll do it tomorrow.";
                                break;
                            case 1:
                                Line = pName + " is browsing dank memes on the internet.";
                                break;
                            case 2:
                                Line = pName + " can't be bothered with it.";
                                break;
                            case 3:
                                Line = pName + " asks for cola, because "+he+"'s too lazy \nto get it " + him + "self.";
                                break;
                        }
                        break;
                    //student teen
                    case 4:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " got a perfect grade for "+his+" test!";
                                break;
                            case 1:
                                Line = pName + " wants to become a doctor when " + he + " grows up.";
                                break;
                            case 2:
                                Line = pName + " is studying vigorously.";
                                break;
                            case 3:
                                Line = pName + " got elected as honour student again.";
                                break;
                        }
                        break;
                    //ambitious teen
                    case 5:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " wants to be just like you!";
                                break;
                            case 1:
                                Line = pName + " smiles as " + he + " stares into the distance.";
                                break;
                            case 2:
                                Line = pName + " will work hard for a better tomorrow!";
                                break;
                            case 3:
                                Line = pName + " uses a lot of exclemation marks as " + he + " speaks!!!";
                                break;
                        }
                        break;
                    //edgelord teen
                    case 6:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " proclaims that it isn't a phase, \nbut who " + he + " really is.";
                                break;
                            case 1:
                                Line = pName + " exclaims that nobody can understand " + him + ".";
                                break;
                            case 2:
                                Line = pName + " is posting angrily on online fora.";
                                break;
                            case 3:
                                Line = pName + " threatens to kill " + him + "self.";
                                break;
                        }
                        break;
                    //neet adult
                    case 7:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " is watching children cartoons.";
                                break;
                            case 1:
                                Line = pName + " made an half-assed solicitation attempt, \nbut got turned down.";
                                break;
                            case 2:
                                Line = pName + " spent " + his + " entire allowance on plastic figures.";
                                break;
                            case 3:
                                Line = pName + " asks for money.";
                                break;
                        }
                        break;
                    //philosopher adult
                    case 8:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " found the answer to the question of life,\nthe universe and everything.";
                                break;
                            case 1:
                                Line = pName + " finally found the answer, but can't remember \nthe question anymore.";
                                break;
                            case 2:
                                Line = pName + " ponders the reason of our existance.";
                                break;
                            case 3:
                                Line = pName + " is meditating.\nNo wait, " + he + "'s just asleep.";
                                break;
                        }
                        break;
                    //scientist adult
                    case 9:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " created another miracle cure.";
                                break;
                            case 1:
                                Line = pName + " solves the unsolvable.";
                                break;
                            case 2:
                                Line = pName + " brings another Nobel prize home.";
                                break;
                            case 3:
                                Line = pName + " talks in difficult and scientificish terms.";
                                break;
                        }
                        break;
                    //evil adult
                    case 10:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " is working on the blueprints of a doomsday device.";
                                break;
                            case 1:
                                Line = pName + " laughs manically.";
                                break;
                            case 2:
                                Line = pName + " tries to kick a dog, but is hindered\nby the fact that" + he + " doesn't have legs.";
                                break;
                            case 3:
                                Line = pName + " rehearses "+his+" world domination speech\nin front of the mirror.";
                                break;
                        }
                        break;
                    //hero adult
                    case 11:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " stares heroicly into the distance.";
                                break;
                            case 1:
                                Line = pName + " flexes a boulder, because "+he+" can.";
                                break;
                            case 2:
                                Line = pName + " flexes " + him + "self, just to show\nanything is possible.";
                                break;
                            case 3:
                                Line = pName + " saves a puppy, old lady and an entire orphanage\nfrom a fire infested with poisonous laser-sharks.";
                                break;
                        }
                        break;
                    //business adult
                    case 12:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " comes home after a long day of work.";
                                break;
                            case 1:
                                Line = pName + " is glad that "+he+" can count on your support.";
                                break;
                            case 2:
                                Line = pName + " leaves the excess money after "+his+" monthly \nexpenses for more difficult times.";
                                break;
                            case 3:
                                Line = pName + " thinks about settling down, but isn't quite \nready yet.";
                                break;
                        }
                        break;
                    //dement elder
                    case 13:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " forgot what "+he+" was about to do.";
                                break;
                            case 1:
                                Line = pName + " wanted to say something, but can't quite remember what.";
                                break;
                            case 2:
                                Line = pName + " stands up, but sits down again after forgetting \nwhat "+he+" was about to do.";
                                break;
                            case 3:
                                Line = pName + " says " + he + " remembers something that clearly \nhas never happened.";
                                break;
                        }
                        break;
                    //wise elder
                    case 14:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " says it's dangerous to go alone, \nand hands you a sword.";
                                break;
                            case 1:
                                Line = pName + " says something deep and incomprehensible.";
                                break;
                            case 2:
                                Line = pName + " has gained a religious cult which \nfollows " + his + " teachings.";
                                break;
                            case 3:
                                Line = pName + " says we are our own greatest enemies, \nand starts fighting " + him + "self.";
                                break;
                        }
                        break;
                    //cyborg elder
                    case 15:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " proclaims that this world revolves \naround memes, Jack.";
                                break;
                            case 1:
                                Line = pName + " knows "+he+" can't run away from death forever, \nbut that doesn't keep "+him+" from trying.";
                                break;
                            case 2:
                                Line = pName + " pops open "+his+" arm, \nand produces a sweet roll.";
                                break;
                            case 3:
                                Line = pName + " has finally obtained limbs and opposable \nthumbs through artificial enhancement.";
                                break;
                        }
                        break;
                    //overlord elder
                    case 16:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " plungs this world into a post-apocalyptic dystopia.";
                                break;
                            case 1:
                                Line = pName + " explains its all futile, for "+he+" is the new ruler of this world.";
                                break;
                            case 2:
                                Line = pName + " supresses all of " + his + " political opponents, \nand demolishes the democratic system.";
                                break;
                            case 3:
                                Line = pName + " publically executes all those who \nwronged "+him+" in the past.";
                                break;
                        }
                        break;
                    //cranky elder
                    case 17:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " stares out of the window with empty eyes.";
                                break;
                            case 1:
                                Line = pName + " hears children playing on "+his+" lawn, \nand grabs "+his+" shotgun.";
                                break;
                            case 2:
                                Line = pName + " says "+he+"'s not one a bit excited.";
                                break;
                            case 3:
                                Line = pName + " tries to tie balloons to "+his+" house.";
                                break;
                        }
                        break;
                    //retired elder
                    case 18:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " stares heroicly into the distance.";
                                break;
                            case 1:
                                Line = pName + " reminiscences the past.";
                                break;
                            case 2:
                                Line = pName + " has to quit volunteer work because of \n" +his+" decaying health.";
                                break;
                            case 3:
                                Line = pName + " says " + he + " has lived a life without regret.";
                                break;
                        }
                        break;
                    //old elder
                    case 19:
                        switch (pickOne)
                        {
                            case 0:
                                Line = pName + " stares out of the window.";
                                break;
                            case 1:
                                Line = pName + " is patiently waiting.";
                                break;
                            case 2:
                                Line = pName + " stands up, but sits down again after hurting \nhis back.";
                                break;
                            case 3:
                                Line = pName + " is glad to have met you.";
                                break;
                        }
                        break;
                }

                if (Properties.Settings.Default.Weight > 240)
                {
                    if (pickOne < 2)
                    {
                        if (Properties.Settings.Default.Weight > 270)
                        {
                            Line = pName + " is morbidly obese.";
                        }
                        else
                        {
                            Line = pName + " has put on some weight.";
                        }
                            
                    }
                    
                }

                if (Properties.Settings.Default.Sickness > 5)
                {
                    if (Properties.Settings.Default.Sickness > 50)
                    {
                        Line = pName + " is horribly sick!";
                    }
                    else
                    {
                        Line = pName + " is feeling a little under the weather.";
                    }
                }
                lblInfo.Text = Line;
            }

            
        }

        private void btnFeed_Click(object sender, EventArgs e)
        {
            needsUpdate();
            if (Properties.Settings.Default.Hunger > 90)
            {
                lblInfo.Text = pName + " is'nt particularly hungry.";
            }
            else 
            {
                if (Properties.Settings.Default.Hunger > 75)
                {
                    Properties.Settings.Default.Weight += 10;
                }
                else if (Properties.Settings.Default.Hunger > 50)
                {
                    Properties.Settings.Default.Weight += 5;
                }
                Properties.Settings.Default.Hunger = 100;
                needsUpdate();
            }
            
        }

        private void btnPlay_Click(object sender, EventArgs e)
        {
            if (Properties.Settings.Default.Fun > 99)
            {
                lblInfo.Text = pName + " is having a extremely strong feeling \nof déjà vu.";
            }
            else
            {
                lblInfo.Text = pName + " happily plays with you!";
                needsUpdate();
                if (Properties.Settings.Default.Fun > 10)
                {
                    Properties.Settings.Default.Lazyness += 20;
                }
                Properties.Settings.Default.Fun = 50;
                needsUpdate();
            }
        }

        private void btnClean_Click(object sender, EventArgs e)
        {
            if (Properties.Settings.Default.Hygiene > 99)
            {
                lblInfo.Text = "You thoroughly clean " + pName + "'s pen again.\n" + pName + " looks at you weirdly.";
            }
            else if (Properties.Settings.Default.Hygiene > 5)
            {
                lblInfo.Text = "You thoroughly clean " + pName + "'s pen.";
            }
            else
            {
                lblInfo.Text = "You thoroughly clean " + pName + "'s pen,\nlike the responsible owner you are.";
            }
            needsUpdate();
            Properties.Settings.Default.Hygiene = 50;
            needsUpdate();
        }
    }
}
