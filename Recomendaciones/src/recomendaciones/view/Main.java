package recomendaciones.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

import recomendaciones.base.*;
import recomendaciones.jess.*;
import recomendaciones.model.*;
import jess.*;

import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel2_1;
	private JButton btnReader, btnExpert, btnNext, btnNext_1, btnNext_2, btnNext_3, btnNext_2_1;
	private JScrollPane scrollPane_2, scrollPane_2_1; 
	
	private JLabel lbl1_1;
	private JLabel lbl1_2;
	private JTextField txtAge;
	private JRadioButton rdbtnYes_1, rdbtnNo_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxNarrative, chckbxLyric, chckbxDrama, chckbxDidactic; 
	private JCheckBox chckbxArt,chckbxCrime,chckbxParanormal,chckbxRomance,chckbxSpirituality,chckbxBiography,chckbxClassics;
	private JCheckBox chckbxHistoricalFiction,chckbxMemoir,chckbxPhilosophy,chckbxScience,chckbxSports,chckbxBusiness,chckbxGraphicNovels;
	private JCheckBox chckbxComics,chckbxFantasy,chckbxHistory,chckbxMusic,chckbxPoetry,chckbxScienceFiction,chckbxThriller;
	private JCheckBox chckbxContemporary,chckbxFiction,chckbxHorror,chckbxMystery,chckbxChickLit,chckbxPsychology,chckbxSelfHelp;
	private JCheckBox chckbxChildrens,chckbxHumorAndComedy,chckbxNonFiction,chckbxReligion,chckbxSuspense, chckbxYoungadult;
	
	private JRadioButton rdbtnCooperate, rdbtnCompete, rdbtnEnjoy, rdbtnGetBored, rdbtnWhatExperiencesHave, rdbtnWhatMyHeart, rdbtnDisorderedAndMessed, rdbtnOrderedAndNeat;
	private JRadioButton rdbtnStayReadingAt, rdbtnGoToA, rdbtnWaitForSomeone, rdbtnHurryToAttend, rdbtnOnTheIdea, rdbtnOnTheDetails, rdbtnEmotionsThanPrinciples;
	private JRadioButton rdbtnPrinciplesThanEmotions, rdbtnRespected, rdbtnFlexible, rdbtnAlone, rdbtnInGroup, rdbtnWhy, rdbtnWhoWhatWhen, rdbtnAGeneralDescription;
	private JRadioButton rdbtnAAPlan, rdbtnJustice, rdbtnCompassion, rdbtnHear, rdbtnTalk, rdbtnSaveTheWorld, rdbtnBeAMillionaire, rdbtnWarmAndTender, rdbtnFirmAndDetermined;
	private JRadioButton rdbtnToDoIt_1, rdbtnToDoIt, rdbtnNewRadioButton, rdbtnBeConcrete, rdbtnABitLate, rdbtnAtTime, rdbtnWaitForThe, rdbtnStartTheConversation;
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	private final ButtonGroup buttonGroup_8 = new ButtonGroup();
	private final ButtonGroup buttonGroup_9 = new ButtonGroup();
	private final ButtonGroup buttonGroup_10 = new ButtonGroup();
	private final ButtonGroup buttonGroup_11 = new ButtonGroup();
	private final ButtonGroup buttonGroup_12 = new ButtonGroup();
	private final ButtonGroup buttonGroup_13 = new ButtonGroup();
	private final ButtonGroup buttonGroup_14 = new ButtonGroup();
	private final ButtonGroup buttonGroup_15 = new ButtonGroup();
	private final ButtonGroup buttonGroup_16 = new ButtonGroup();
	private final ButtonGroup buttonGroup_17 = new ButtonGroup();
	private final ButtonGroup buttonGroup_18 = new ButtonGroup();
	private final ButtonGroup buttonGroup_19 = new ButtonGroup();
	private final ButtonGroup buttonGroup_20 = new ButtonGroup();
	
	
	private int age, a, b, c, d;
	private boolean esLector;
	private String personality;
	private ArrayList<String> genres = new ArrayList<String>(), themes = new ArrayList<String>();
	private ArrayList<String> recommendGenres = new ArrayList<String>(), recommendThemes = new ArrayList<String>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*
		Conexion conn = new Conexion();
        if(conn.crearConexion()){
            try {
                System.out.println("Establecida");
                
                ResultSet rs= conn.ejecutarSQLSelect("SELECT * FROM books");
                while(rs.next()){
                    System.out.println(rs.getString("title")+" -> "+rs.getString("author"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BasesDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.print("Sin conexion");
        }
        */
    }

	/**
	 * Function that searches into the rules of knowledge base, the ones that fit to
	 * the personality given to it as a parameter.
	 */
	private static ArrayList<String> processInput(RecommendEngine engine, String personality) throws JessException {
		Iterator themes;
		ArrayList<String> recommendedThemes = new ArrayList<>();
		String temp;
		
		System.out.println("Personality inserted: " + personality);
				
		themes = engine.run(personality);
		System.out.println("Themes for personality " + personality + ":");
		while (themes.hasNext()) {
			temp = themes.next().toString();
			recommendedThemes.add(temp);
			System.out.println("   " + temp);
		}
		//System.out.println("List of recommendations" + recommendedThemes);
		return recommendedThemes;
	}	
	
	/**
	 * Call to the functions initComponents and createEvents.
	 */
	public Main() {
		setResizable(false);
		setBounds(new Rectangle(0, 0, 0, 1000));
		initComponents();
		createEvents();
	}
	
	
	/**
	 * Function that contains all the components inside the frame:
	 * all the panels, in which we find buttons, labels, etc. 
	 */
	private void initComponents(){
		setTitle("Recommend a Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setViewportBorder(null);
		scrollPane_2.setBounds(0, 0, 575, 375);
		contentPane.add(scrollPane_2);
		scrollPane_2.setVisible(false);
		panel2 = new JPanel();
		scrollPane_2.setViewportView(panel2);
		
		JLabel lblTest = new JLabel("Take the Personality Test:");
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNext = new JButton("Next ->");
		
		JLabel lblQuestion1 = new JLabel("1. With my colleagues, or classmates, I:");
		
		rdbtnCompete = new JRadioButton("Compete");
		buttonGroup_1.add(rdbtnCompete);
		
		rdbtnCooperate = new JRadioButton("Cooperate");
		buttonGroup_1.add(rdbtnCooperate);
		
		JLabel lblWhenSpending = new JLabel("2. When spending time alone, I:");
		
		rdbtnGetBored = new JRadioButton("Get bored");
		buttonGroup_2.add(rdbtnGetBored);
		
		rdbtnEnjoy = new JRadioButton("Enjoy");
		buttonGroup_2.add(rdbtnEnjoy);
		
		JLabel lblITrust = new JLabel("3. I trust:");
		
		rdbtnWhatMyHeart = new JRadioButton("What my heart tells me");
		buttonGroup_3.add(rdbtnWhatMyHeart);
		
		rdbtnWhatExperiencesHave = new JRadioButton("What experiences have proven");
		buttonGroup_3.add(rdbtnWhatExperiencesHave);
		
		JLabel lblMyBedroom = new JLabel("4. My bedroom is usually:");
		
		rdbtnOrderedAndNeat = new JRadioButton("Ordered and neat");
		buttonGroup_4.add(rdbtnOrderedAndNeat);
		
		rdbtnDisorderedAndMessed = new JRadioButton("Disordered and messed up");
		buttonGroup_4.add(rdbtnDisorderedAndMessed);
		
		JLabel lblInA = new JLabel("5. In a day off, I will rather:");
		
		rdbtnGoToA = new JRadioButton("Go to a mall");
		buttonGroup_5.add(rdbtnGoToA);
		
		rdbtnStayReadingAt = new JRadioButton("Stay reading at home");
		buttonGroup_5.add(rdbtnStayReadingAt);
		
		JLabel lblWhenThe = new JLabel("6. When the bell is ringing, I generally:");
		
		rdbtnHurryToAttend = new JRadioButton("Hurry to attend whoever is at the door.");
		buttonGroup_6.add(rdbtnHurryToAttend);
		
		rdbtnWaitForSomeone = new JRadioButton("Wait for someone else to attend");
		buttonGroup_6.add(rdbtnWaitForSomeone);
		
		JLabel lblwhenLookingAt = new JLabel("7. When looking at an artistic painting, I focus:");
		
		rdbtnOnTheDetails = new JRadioButton("On the details");
		buttonGroup_7.add(rdbtnOnTheDetails);
		
		rdbtnOnTheIdea = new JRadioButton("On the idea behind the painting");
		buttonGroup_7.add(rdbtnOnTheIdea);
		
		JLabel lblNewLabel_1 = new JLabel("8. For me, are more important:");
		
		rdbtnPrinciplesThanEmotions = new JRadioButton("Principles than emotions");
		buttonGroup_8.add(rdbtnPrinciplesThanEmotions);
		
		rdbtnEmotionsThanPrinciples = new JRadioButton("Emotions than principles");
		buttonGroup_8.add(rdbtnEmotionsThanPrinciples);
		
		JLabel lblNewLabel_2 = new JLabel("9. Deadlines for submitting a work, should be:");
		
		rdbtnFlexible = new JRadioButton("Flexible");
		buttonGroup_9.add(rdbtnFlexible);
		
		rdbtnRespected = new JRadioButton("Respected");
		buttonGroup_9.add(rdbtnRespected);
		
		JLabel lblPreferTo = new JLabel("10. Prefer to work:");
		
		rdbtnInGroup = new JRadioButton("In group");
		buttonGroup_10.add(rdbtnInGroup);
		
		rdbtnAlone = new JRadioButton("Alone");
		buttonGroup_10.add(rdbtnAlone);
		
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnCooperate)
								.addComponent(rdbtnCompete)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWhenSpending)
								.addComponent(lblITrust)
								.addComponent(lblMyBedroom)
								.addComponent(lblInA)
								.addComponent(lblWhenThe)
								.addComponent(lblwhenLookingAt)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblQuestion1)
								.addComponent(lblPreferTo)
								.addComponent(btnNext)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnEnjoy)
								.addComponent(rdbtnGetBored)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnWhatExperiencesHave)
								.addComponent(rdbtnWhatMyHeart)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnDisorderedAndMessed)
								.addComponent(rdbtnOrderedAndNeat)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnStayReadingAt)
								.addComponent(rdbtnGoToA)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnWaitForSomeone)
								.addComponent(rdbtnHurryToAttend)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnOnTheIdea)
								.addComponent(rdbtnOnTheDetails)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnEmotionsThanPrinciples)
								.addComponent(rdbtnPrinciplesThanEmotions)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnRespected)
								.addComponent(rdbtnFlexible)))
						.addGroup(gl_panel2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTest))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnAlone)
								.addComponent(rdbtnInGroup))))
					.addContainerGap(311, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTest)
					.addGap(16)
					.addComponent(lblQuestion1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCompete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCooperate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenSpending)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnGetBored)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnEnjoy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblITrust)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWhatMyHeart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWhatExperiencesHave)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMyBedroom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOrderedAndNeat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDisorderedAndMessed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnGoToA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnStayReadingAt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenThe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnHurryToAttend)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWaitForSomeone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblwhenLookingAt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOnTheDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOnTheIdea)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnPrinciplesThanEmotions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnEmotionsThanPrinciples)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnFlexible)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnRespected)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPreferTo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnInGroup)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAlone)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNext)
					.addContainerGap())
		);
		panel2.setLayout(gl_panel2);
		
		panel2.setVisible(false);
		
		panel3 = new JPanel();
		panel3.setBounds(0, 0, 575, 375);
		contentPane.add(panel3);
		
		JLabel lblNewLabel = new JLabel("Enter your age:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		
		//For validating the text field for age to be just numbers, not letters or other symbols
		txtAge.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	          char c = e.getKeyChar();
	          if (!((c >= '0') && (c <= '9') ||
	             (c == KeyEvent.VK_BACK_SPACE) ||
	             (c == KeyEvent.VK_DELETE))) {
	            getToolkit().beep();
	            e.consume();
	          }
	        }
	      });
		
		JLabel lblDoYouEnojy = new JLabel("Do you enjoy reading frequently?");
		lblDoYouEnojy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdbtnYes_1 = new JRadioButton("Yes");
		buttonGroup.add(rdbtnYes_1);
		
		rdbtnNo_1 = new JRadioButton("No");
		buttonGroup.add(rdbtnNo_1);
		
		btnNext_1 = new JButton("Next ->");
		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext_1)
						.addGroup(gl_panel3.createSequentialGroup()
							.addComponent(rdbtnYes_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNo_1))
						.addComponent(lblDoYouEnojy)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDoYouEnojy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnYes_1)
						.addComponent(rdbtnNo_1))
					.addGap(29)
					.addComponent(btnNext_1)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		panel3.setVisible(false);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 575, 375);
		
		lbl1_1 = new JLabel("Welcome new user to the system that will recommend you a book.");
		lbl1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl1_2 = new JLabel("Choose the type of user:");
		lbl1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnReader = new JButton("Reader");
		
		btnExpert = new JButton("Expert");
		
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(btnReader)
							.addGap(18)
							.addComponent(btnExpert))
						.addComponent(lbl1_1)
						.addComponent(lbl1_2))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl1_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl1_2)
					.addGap(41)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReader)
						.addComponent(btnExpert))
					.addGap(29))
		);
		panel1.setLayout(gl_panel1);
		
//		panel3 = new Reader_esLector();
//		panel3.setBounds(20, 20, 444, 350);
//		panel3.setVisible(false);

//		panel2 = new Reader_TestPersonalidad();
//		panel2.setBounds(20, 20, 444, 350);
//		panel2.setVisible(false);
		
		contentPane.add(panel1);
		
		scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setViewportBorder(null);
		scrollPane_2_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2_1.setBounds(0, 0, 575, 375);
		contentPane.add(scrollPane_2_1);
		scrollPane_2_1.setVisible(false);
		
		panel2_1 = new JPanel();
		scrollPane_2_1.setViewportView(panel2_1);
		
		JLabel lblWhenA = new JLabel("11. When something happens, I would like to know:");
		
		rdbtnWhoWhatWhen = new JRadioButton("Who? What? When?");
		buttonGroup_11.add(rdbtnWhoWhatWhen);
		
		rdbtnWhy = new JRadioButton("Why?");
		buttonGroup_11.add(rdbtnWhy);
		
		rdbtnWhoWhatWhen.setSelected(true);
		
		JLabel lblWhenI = new JLabel("12. When I have a work to do, I prefer to have:");
		
		rdbtnAAPlan = new JRadioButton("A plan with defined tasks to be done, in order to accomplish the objective");
		buttonGroup_12.add(rdbtnAAPlan);
		
		rdbtnAGeneralDescription = new JRadioButton("A general description of the objective and no plan");
		buttonGroup_12.add(rdbtnAGeneralDescription);
		
		rdbtnAAPlan.setSelected(true);
		
		JLabel lblForMe = new JLabel("13. For me, morality is based on:");
		
		rdbtnCompassion = new JRadioButton("Compassion");
		buttonGroup_13.add(rdbtnCompassion);
		
		rdbtnJustice = new JRadioButton("Justice");
		buttonGroup_13.add(rdbtnJustice);
		
		rdbtnCompassion.setSelected(true);
		
		JLabel lblIn = new JLabel("14. In a conversation with a friend, I frequently:");
		
		rdbtnTalk = new JRadioButton("Talk");
		buttonGroup_14.add(rdbtnTalk);
		
		rdbtnHear = new JRadioButton("Hear");
		buttonGroup_14.add(rdbtnHear);
		
		rdbtnTalk.setSelected(true);
		
		JLabel lblNewLabel_3 = new JLabel("15. When I grow up, I would like to:");
		
		rdbtnBeAMillionaire = new JRadioButton("Be a millionaire");
		buttonGroup_15.add(rdbtnBeAMillionaire);
		
		rdbtnSaveTheWorld = new JRadioButton("Save the world");
		buttonGroup_15.add(rdbtnSaveTheWorld);
		
		rdbtnBeAMillionaire.setSelected(true);
		
		JLabel lblIConsider = new JLabel("16. I consider myself to be a person:");
		
		rdbtnFirmAndDetermined = new JRadioButton("Firm and determined");
		buttonGroup_16.add(rdbtnFirmAndDetermined);
		
		rdbtnWarmAndTender = new JRadioButton("Warm and tender");
		buttonGroup_16.add(rdbtnWarmAndTender);
		
		rdbtnFirmAndDetermined.setSelected(true);
		
		JLabel lblWhenDoing = new JLabel("17. When doing my routine, I prefer:");
		
		rdbtnToDoIt = new JRadioButton("To do it as always");
		buttonGroup_17.add(rdbtnToDoIt);
		
		rdbtnToDoIt_1 = new JRadioButton("To do it in a different way");
		buttonGroup_17.add(rdbtnToDoIt_1);
		
		rdbtnToDoIt.setSelected(true);
		
		JLabel lblInA_1 = new JLabel("18. In a conversation, I  would rather be:");
		
		rdbtnBeConcrete = new JRadioButton("Concrete");
		buttonGroup_18.add(rdbtnBeConcrete);
		
		rdbtnNewRadioButton = new JRadioButton("Vague");
		buttonGroup_18.add(rdbtnNewRadioButton);
		
		rdbtnBeConcrete.setSelected(true);
		
		JLabel lblIUsually = new JLabel("19. I usually get to a reunion:");
		
		rdbtnAtTime = new JRadioButton("At time");
		buttonGroup_19.add(rdbtnAtTime);
		
		rdbtnABitLate = new JRadioButton("A bit late");
		buttonGroup_19.add(rdbtnABitLate);
		
		rdbtnAtTime.setSelected(true);
		
		JLabel lblAccompaniedI = new JLabel("20. Accompanied, I:");
		
		rdbtnStartTheConversation = new JRadioButton("Start the conversation");
		buttonGroup_20.add(rdbtnStartTheConversation);
		
		rdbtnWaitForThe = new JRadioButton("Wait for the other to start the conversation");
		buttonGroup_20.add(rdbtnWaitForThe);
		
		rdbtnStartTheConversation.setSelected(true);
		
		btnNext_2_1 = new JButton("Next ->");
		
		GroupLayout gl_panel2_1 = new GroupLayout(panel2_1);
		gl_panel2_1.setHorizontalGroup(
			gl_panel2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2_1.createSequentialGroup()
					.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnWhy)
								.addComponent(rdbtnWhoWhatWhen)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWhenI)
								.addComponent(lblWhenA)
								.addComponent(lblForMe)
								.addComponent(lblIn)
								.addComponent(lblNewLabel_3)
								.addComponent(lblIConsider)
								.addComponent(lblWhenDoing)
								.addComponent(lblInA_1)
								.addComponent(lblAccompaniedI)
								.addComponent(lblIUsually)
								.addComponent(btnNext_2_1)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnAGeneralDescription)
								.addComponent(rdbtnAAPlan)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnJustice)
								.addComponent(rdbtnCompassion)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnHear)
								.addComponent(rdbtnTalk)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnSaveTheWorld)
								.addComponent(rdbtnBeAMillionaire)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnWarmAndTender)
								.addComponent(rdbtnFirmAndDetermined)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnToDoIt_1)
								.addComponent(rdbtnToDoIt)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnBeConcrete)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnABitLate)
								.addComponent(rdbtnAtTime)))
						.addGroup(gl_panel2_1.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_panel2_1.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnWaitForThe)
								.addComponent(rdbtnStartTheConversation))))
					.addContainerGap(150, Short.MAX_VALUE))
		);
		gl_panel2_1.setVerticalGroup(
			gl_panel2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWhenA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWhoWhatWhen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWhy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenI)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAAPlan)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAGeneralDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblForMe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCompassion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnJustice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTalk)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnHear)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnBeAMillionaire)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnSaveTheWorld)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIConsider)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnFirmAndDetermined)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWarmAndTender)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenDoing)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnToDoIt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnToDoIt_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInA_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnBeConcrete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIUsually)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAtTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnABitLate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAccompaniedI)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnStartTheConversation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnWaitForThe)
					.addGap(18)
					.addComponent(btnNext_2_1)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel2_1.setLayout(gl_panel2_1);
		panel2_1.setVisible(false);
		
		panel4 = new JPanel();
		panel4.setBounds(0, 0, 575, 375);
		contentPane.add(panel4);
		
		JLabel lblChooseYourFavorite = new JLabel("Choose your favorite literary genres:");
		lblChooseYourFavorite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxNarrative = new JCheckBox("Narrative");
		
		chckbxLyric = new JCheckBox("Lyric");
		
		chckbxDrama = new JCheckBox("Drama");
		
		chckbxDidactic = new JCheckBox("Didactic");
		
		btnNext_2 = new JButton("Next ->");
		
		GroupLayout gl_panel4 = new GroupLayout(panel4);
		gl_panel4.setHorizontalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel4.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblChooseYourFavorite))
						.addGroup(gl_panel4.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNarrative)
								.addComponent(chckbxDrama)
								.addComponent(chckbxDidactic)
								.addComponent(chckbxLyric)
								.addComponent(btnNext_2))))
					.addContainerGap(276, Short.MAX_VALUE))
		);
		gl_panel4.setVerticalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseYourFavorite)
					.addGap(18)
					.addComponent(chckbxNarrative)
					.addGap(3)
					.addComponent(chckbxLyric)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxDrama)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxDidactic)
					.addGap(18)
					.addComponent(btnNext_2)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		panel4.setLayout(gl_panel4);
		panel4.setVisible(false);
		
		panel5 = new JPanel();
		panel5.setBounds(0, 0, 575, 375);
		contentPane.add(panel5);
		
		JLabel lblChooseYourFavorite_1 = new JLabel("Choose your favorite themes:");
		lblChooseYourFavorite_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxArt = new JCheckBox("Art");
		
		chckbxCrime = new JCheckBox("Crime");
		
		chckbxParanormal = new JCheckBox("Paranormal");
		
		chckbxRomance = new JCheckBox("Romance");
		
		chckbxSpirituality = new JCheckBox("Spirituality");
		
		chckbxBiography = new JCheckBox("Biography");
		
		chckbxClassics = new JCheckBox("Classics");
		
		chckbxHistoricalFiction = new JCheckBox("Historical Fiction");
		
		chckbxMemoir = new JCheckBox("Memoir");
		
		chckbxPhilosophy = new JCheckBox("Philosophy");
		
		chckbxScience = new JCheckBox("Science");
		
		chckbxSports = new JCheckBox("Sports");
		
		chckbxBusiness = new JCheckBox("Business");
		
		chckbxGraphicNovels = new JCheckBox("Graphic Novels");
		
		chckbxComics = new JCheckBox("Comics");
		
		chckbxFantasy = new JCheckBox("Fantasy");
		
		chckbxHistory = new JCheckBox("History");
		
		chckbxMusic = new JCheckBox("Music");
		
		chckbxPoetry = new JCheckBox("Poetry");
		
		chckbxScienceFiction = new JCheckBox("Science Fiction");
		
		chckbxThriller = new JCheckBox("Thriller");
		
		chckbxContemporary = new JCheckBox("Contemporary");
		
		chckbxFiction = new JCheckBox("Fiction");
		
		chckbxHorror = new JCheckBox("Horror");
		
		chckbxMystery = new JCheckBox("Mystery");
		
		chckbxChickLit = new JCheckBox("Chick lit");
		
		chckbxPsychology = new JCheckBox("Psychology");
		
		chckbxSelfHelp = new JCheckBox("Self Help");
		
		chckbxChildrens = new JCheckBox("Children's");
		
		chckbxHumorAndComedy = new JCheckBox("Humor and Comedy");
		
		chckbxNonFiction = new JCheckBox("Non-fiction");
		
		chckbxReligion = new JCheckBox("Religion");
		
		chckbxSuspense = new JCheckBox("Suspense");
		
		chckbxYoungadult = new JCheckBox("Young-Adult");
		
		btnNext_3 = new JButton("Next ->");
		
		GroupLayout gl_panel5 = new GroupLayout(panel5);
		gl_panel5.setHorizontalGroup(
			gl_panel5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel5.createSequentialGroup()
					.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel5.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblChooseYourFavorite_1))
						.addGroup(gl_panel5.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxArt)
								.addComponent(chckbxCrime)
								.addComponent(chckbxParanormal)
								.addComponent(chckbxRomance)
								.addComponent(chckbxSpirituality)
								.addComponent(chckbxBiography)
								.addComponent(chckbxClassics)
								.addComponent(chckbxHistoricalFiction)
								.addComponent(chckbxMemoir)
								.addComponent(btnNext_3))
							.addGap(31)
							.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxPhilosophy)
								.addComponent(chckbxScience)
								.addComponent(chckbxSports)
								.addComponent(chckbxBusiness)
								.addComponent(chckbxGraphicNovels)
								.addComponent(chckbxComics)
								.addComponent(chckbxFantasy)
								.addComponent(chckbxHistory)
								.addComponent(chckbxMusic))
							.addGap(20)
							.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxPsychology)
								.addComponent(chckbxChickLit)
								.addGroup(gl_panel5.createSequentialGroup()
									.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxPoetry)
										.addComponent(chckbxScienceFiction)
										.addComponent(chckbxThriller)
										.addComponent(chckbxContemporary)
										.addComponent(chckbxFiction)
										.addComponent(chckbxHorror)
										.addComponent(chckbxMystery))
									.addGap(26)
									.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxYoungadult)
										.addComponent(chckbxSuspense)
										.addComponent(chckbxReligion)
										.addComponent(chckbxNonFiction)
										.addComponent(chckbxHumorAndComedy)
										.addComponent(chckbxChildrens)
										.addComponent(chckbxSelfHelp))))))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_panel5.setVerticalGroup(
			gl_panel5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseYourFavorite_1)
					.addGap(18)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxArt)
						.addComponent(chckbxPhilosophy)
						.addComponent(chckbxPoetry)
						.addComponent(chckbxSelfHelp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCrime)
						.addComponent(chckbxScience)
						.addComponent(chckbxScienceFiction)
						.addComponent(chckbxChildrens))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxParanormal)
						.addComponent(chckbxSports)
						.addComponent(chckbxThriller)
						.addComponent(chckbxHumorAndComedy))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxRomance)
						.addComponent(chckbxBusiness)
						.addComponent(chckbxContemporary)
						.addComponent(chckbxNonFiction))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSpirituality)
						.addComponent(chckbxGraphicNovels)
						.addComponent(chckbxFiction)
						.addComponent(chckbxReligion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBiography)
						.addComponent(chckbxComics)
						.addComponent(chckbxHorror)
						.addComponent(chckbxSuspense))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxClassics)
						.addComponent(chckbxFantasy)
						.addComponent(chckbxMystery)
						.addComponent(chckbxYoungadult))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxHistoricalFiction)
						.addComponent(chckbxHistory)
						.addComponent(chckbxChickLit))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel5.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxMemoir)
						.addComponent(chckbxMusic)
						.addComponent(chckbxPsychology))
					.addGap(32)
					.addComponent(btnNext_3)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel5.setLayout(gl_panel5);
		panel5.setVisible(false);
		
		panel6 = new JPanel();
		panel6.setBounds(0, 0, 575, 375);
		contentPane.add(panel6);
		
		JLabel lblRecommendation = new JLabel("Recommendation:");
		lblRecommendation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblWhy = new JLabel("Why?");
		lblWhy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel6 = new GroupLayout(panel6);
		gl_panel6.setHorizontalGroup(
			gl_panel6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel6.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWhy, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecommendation))
					.addContainerGap(452, Short.MAX_VALUE))
		);
		gl_panel6.setVerticalGroup(
			gl_panel6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel6.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRecommendation)
					.addGap(124)
					.addComponent(lblWhy)
					.addContainerGap(206, Short.MAX_VALUE))
		);
		panel6.setLayout(gl_panel6);
		panel6.setVisible(false);
	}
	

	private void createEventPersonalidad(){
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				scrollPane_2.setVisible(false);
				panel2.setVisible(false);
				scrollPane_2_1.setVisible(true);
				panel2_1.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);

				a = 0;
				b = 0;
				c = 0;
				d = 0;
				
				
				if (getSelectedButtonText(buttonGroup_1).equals(rdbtnCompete.getText())){
					c += 1;
				}
				if (getSelectedButtonText(buttonGroup_2).equals(rdbtnGetBored.getText())){
					a += 1;
				}
				if (getSelectedButtonText(buttonGroup_3).equals(rdbtnWhatMyHeart.getText())){
					b += 1;
				}
				if (getSelectedButtonText(buttonGroup_4).equals(rdbtnOrderedAndNeat.getText())){
					d += 1;
				}
				if (getSelectedButtonText(buttonGroup_5).equals(rdbtnGoToA.getText())){
					a += 1;
				}
				if (getSelectedButtonText(buttonGroup_6).equals(rdbtnHurryToAttend.getText())){
					c += 1;
				}
				if (getSelectedButtonText(buttonGroup_7).equals(rdbtnOnTheDetails.getText())){
					b += 1;
				}
				if (getSelectedButtonText(buttonGroup_8).equals(rdbtnPrinciplesThanEmotions.getText())){
					c += 1;
				}
				if (getSelectedButtonText(buttonGroup_9).equals(rdbtnFlexible.getText())){
					d += 1;
				}
				if (getSelectedButtonText(buttonGroup_10).equals(rdbtnInGroup.getText())){
					a += 1;
				}
				
			}
		});
		
		btnNext_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				scrollPane_2.setVisible(false);
				panel2.setVisible(false);
				scrollPane_2_1.setVisible(false);
				panel2_1.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
				
				if (getSelectedButtonText(buttonGroup_11).equals(rdbtnWhoWhatWhen.getText())){
					b += 1;
				}
				if (getSelectedButtonText(buttonGroup_12).equals(rdbtnAAPlan.getText())){
					d += 1;
				}
				if (getSelectedButtonText(buttonGroup_13).equals(rdbtnCompassion.getText())){
					c += 1;
				}
				if (getSelectedButtonText(buttonGroup_14).equals(rdbtnTalk.getText())){
					a += 1;
				}
				if (getSelectedButtonText(buttonGroup_15).equals(rdbtnBeAMillionaire.getText())){
					b += 1;
				}
				if (getSelectedButtonText(buttonGroup_16).equals(rdbtnFirmAndDetermined.getText())){
					c += 1;
				}
				if (getSelectedButtonText(buttonGroup_17).equals(rdbtnToDoIt.getText())){
					d += 1;
				}
				if (getSelectedButtonText(buttonGroup_18).equals(rdbtnBeConcrete.getText())){
					b += 1;
				}
				if (getSelectedButtonText(buttonGroup_19).equals(rdbtnAtTime.getText())){
					d += 1;
				}
				if (getSelectedButtonText(buttonGroup_20).equals(rdbtnStartTheConversation.getText())){
					a += 1;
				}
				
				String at, bt, ct, dt;
				
				System.out.println("Estos son los resultados de las sumas> "+a+b+c+d);
				if(a>2){at = "E";}else{at = "I";}
				if(b>2){bt = "S";}else{bt = "N";}
				if(c>2){ct = "T";}else{ct = "F";}
				if(d>2){dt = "J";}else{dt = "P";}
				
				personality = at+bt+ct+dt;
				System.out.println("Personalidad es igual a> "+personality);
				//personality = "ESTJ";//Esto tengo que definirlo despues con la solucion del test.
			}
		});
	}
	
	private void createEventAge(){
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					age = Integer.parseInt(txtAge.getText());
				}catch(NumberFormatException exception){
					JOptionPane.showMessageDialog(null,"Put the correct format!!! \n"+exception);
				};
					if (getSelectedButtonText(buttonGroup).equals(rdbtnYes_1.getText())){
						esLector = true;
					}
					else{
						esLector = false;
					}


				//Call to the jess engine, for searching into the rules.
				/*try {
		        	RecommendEngine r = new RecommendEngine();
		        	recommendThemes = processInput(r, personality);
		        	
			    } catch (JessException ex) {
			        System.err.println(ex);
			    }*/
				
				//System.out.println("List of recommendations" + recommendThemes);
				
				panel1.setVisible(false);
				scrollPane_2.setVisible(false);
				panel2.setVisible(false);
				scrollPane_2_1.setVisible(false);
				panel2_1.setVisible(false);				
				panel3.setVisible(false);
				if (esLector){
					panel4.setVisible(true);
					panel5.setVisible(false);
					panel6.setVisible(false);
				}
				else{
					panel4.setVisible(false);
					panel5.setVisible(false);
					panel6.setVisible(true);
				}
				
			}
		});
	}
	
	private void createEventGenre(){
		btnNext_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				scrollPane_2.setVisible(false);
				panel2.setVisible(false);
				scrollPane_2_1.setVisible(false);
				panel2_1.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(true);
				panel6.setVisible(false);
				
				if (chckbxNarrative.isSelected()){
					genres.add(chckbxNarrative.getText());
				}
				if (chckbxLyric.isSelected()){
					genres.add(chckbxLyric.getText());
				}
				if (chckbxDrama.isSelected()){
					genres.add(chckbxDrama.getText());
				}
				if (chckbxDidactic.isSelected()){
					genres.add(chckbxDidactic.getText());
				}
				//System.out.println("This are the selected genres> " + genres);
			}
		});
		
	}

	private void createEventTheme(){
		btnNext_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				scrollPane_2.setVisible(false);
				panel2.setVisible(false);
				scrollPane_2_1.setVisible(false);
				panel2_1.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(true);
				
				if (chckbxArt.isSelected()){
					themes.add(chckbxArt.getText());
				}
				if (chckbxCrime.isSelected()){
					themes.add(chckbxCrime.getText());
				}
				if (chckbxParanormal.isSelected()){
					themes.add(chckbxParanormal.getText());
				}
				if (chckbxRomance.isSelected()){
					themes.add(chckbxRomance.getText());
				}
				if (chckbxSpirituality.isSelected()){
					themes.add(chckbxSpirituality.getText());
				}
				if (chckbxBiography.isSelected()){
					themes.add(chckbxBiography.getText());
				}
				if (chckbxClassics.isSelected()){
					themes.add(chckbxClassics.getText());
				}
				if (chckbxHistoricalFiction.isSelected()){
					themes.add(chckbxHistoricalFiction.getText());
				}
				if (chckbxMemoir.isSelected()){
					themes.add(chckbxMemoir.getText());
				}
				if (chckbxPhilosophy.isSelected()){
					themes.add(chckbxPhilosophy.getText());
				}
				if (chckbxScience.isSelected()){
					themes.add(chckbxScience.getText());
				}
				if (chckbxSports.isSelected()){
					themes.add(chckbxSports.getText());
				}
				if (chckbxBusiness.isSelected()){
					themes.add(chckbxBusiness.getText());
				}
				if (chckbxGraphicNovels.isSelected()){
					themes.add(chckbxGraphicNovels.getText());
				}
				if (chckbxComics.isSelected()){
					themes.add(chckbxComics.getText());
				}
				if (chckbxFantasy.isSelected()){
					themes.add(chckbxFantasy.getText());
				}
				if (chckbxHistory.isSelected()){
					themes.add(chckbxHistory.getText());
				}
				if (chckbxMusic.isSelected()){
					themes.add(chckbxMusic.getText());
				}
				if (chckbxPoetry.isSelected()){
					themes.add(chckbxPoetry.getText());
				}
				if (chckbxScienceFiction.isSelected()){
					themes.add(chckbxScienceFiction.getText());
				}
				if (chckbxThriller.isSelected()){
					themes.add(chckbxThriller.getText());
				}
				if (chckbxContemporary.isSelected()){
					themes.add(chckbxContemporary.getText());
				}
				if (chckbxFiction.isSelected()){
					themes.add(chckbxFiction.getText());
				}
				if (chckbxHorror.isSelected()){
					themes.add(chckbxHorror.getText());
				}
				if (chckbxMystery.isSelected()){
					themes.add(chckbxMystery.getText());
				}
				if (chckbxChickLit.isSelected()){
					themes.add(chckbxChickLit.getText());
				}
				if (chckbxPsychology.isSelected()){
					themes.add(chckbxPsychology.getText());
				}
				if (chckbxSelfHelp.isSelected()){
					themes.add(chckbxSelfHelp.getText());
				}
				if (chckbxChildrens.isSelected()){
					themes.add(chckbxChildrens.getText());
				}
				if (chckbxHumorAndComedy.isSelected()){
					themes.add(chckbxHumorAndComedy.getText());
				}
				if (chckbxNonFiction.isSelected()){
					themes.add(chckbxNonFiction.getText());
				}
				if (chckbxReligion.isSelected()){
					themes.add(chckbxReligion.getText());
				}
				if (chckbxSuspense.isSelected()){
					themes.add(chckbxSuspense.getText());
				}
				if (chckbxYoungadult.isSelected()){
					themes.add(chckbxYoungadult.getText());
				}
				//System.out.println("This are the selected themes> " + themes);
			}
		});
	}
	
	/**
	 * Function that contains all the actions done with the buttons.
	 * Here are all the buttons' actions.
	 * Functions: createEventTheme, createEventGenre, createEventPersonality, createEventAge
	 */
	private void createEvents(){
		btnReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				scrollPane_2.setVisible(true);
				panel2.setVisible(true);
				scrollPane_2_1.setVisible(false);
				panel2_1.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
				panel6.setVisible(false);
			}
		});
	
		createEventPersonalidad();
		createEventAge();
		createEventGenre();
		createEventTheme();
	}
	
	
	/**
	 * Auxiliary Function that gets the text from a selected Button in a Button Group.
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
	
	public void getRecommendedBook(ArrayList<String> jessThemes, ArrayList<String> jessGenres){
		Conexion conn = new Conexion();
        if(conn.crearConexion()){
            try {
                System.out.println("Establecida");
                
                ResultSet rs= conn.ejecutarSQLSelect("SELECT b.title "
                		+ "FROM books as b, themes as t, books_themes as bt "
                		+ "WHERE b.idB = bt.idBooks "
                		+ "AND t.idT = bt.idThemes "
                		+ "AND t.theme = "
                		+ ";");
                while(rs.next()){
                    System.out.println(rs.getString("title")+" -> "+rs.getString("author"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BasesDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.print("Sin conexion");
        }
	}
}
