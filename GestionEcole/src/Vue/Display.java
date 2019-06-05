/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.*;
import Modele.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adrie
 */
public class Display extends JFrame implements ActionListener, ItemListener {

    private JMenuBar menu;
    private MenuItemListener menuItemListener;
    private JPanel content;

    public Display() {
        super();
        this.setup();
    }

    private void setup() {
        this.setTitle("Projet POO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        menu = new JMenuBar();
        menuItemListener = new MenuItemListener();
        content = new JPanel();
        //content.setBackground(Color.green);

        // Create menus
        JMenu menu1 = new JMenu("Modifier");
        JMenu menu2 = new JMenu("Ajouter");
        JMenu menu3 = new JMenu("Analyse");

        // Create options
        JMenuItem modif_eleve = new JMenuItem("modif_eleve");
        modif_eleve.setActionCommand("modif_eleve");
        modif_eleve.addActionListener(menuItemListener);
        menu1.add(modif_eleve);

        JMenuItem ajouter_eleve = new JMenuItem("ajouter_eleve");
        ajouter_eleve.setActionCommand("ajouter_eleve");
        ajouter_eleve.addActionListener(menuItemListener);
        menu2.add(ajouter_eleve);
        
        JMenuItem ajouter_annee = new JMenuItem("ajouter_annee");
        ajouter_annee.setActionCommand("ajouter_annee");
        ajouter_annee.addActionListener(menuItemListener);
        menu2.add(ajouter_annee);
        
        JMenuItem ajouter_matiere = new JMenuItem("ajouter_matiere");
        ajouter_matiere.setActionCommand("ajouter_matiere");
        ajouter_matiere.addActionListener(menuItemListener);
        menu2.add(ajouter_matiere);
        
        JMenuItem ajouter_niveau = new JMenuItem("ajouter_niveau");
        ajouter_niveau.setActionCommand("ajouter_niveau");
        ajouter_niveau.addActionListener(menuItemListener);
        menu2.add(ajouter_niveau);
        
        JMenuItem ajouter_classe = new JMenuItem("ajouter_classe");
        ajouter_classe.setActionCommand("ajouter_classe");
        ajouter_classe.addActionListener(menuItemListener);
        menu2.add(ajouter_classe);
        
        JMenuItem ajouter_prof = new JMenuItem("ajouter_prof");
        ajouter_prof.setActionCommand("ajouter_prof");
        ajouter_prof.addActionListener(menuItemListener);
        menu2.add(ajouter_prof);
        
        JMenuItem ajouter_cours = new JMenuItem("ajouter_cours");
        ajouter_cours.setActionCommand("ajouter_cours");
        ajouter_cours.addActionListener(menuItemListener);
        menu2.add(ajouter_cours);
        
        JMenuItem ajouter_note = new JMenuItem("ajouter_note");
        ajouter_note.setActionCommand("ajouter_note");
        ajouter_note.addActionListener(menuItemListener);
        menu2.add(ajouter_note);
        
        JMenuItem ajouter_bulletin = new JMenuItem("ajouter_bulletin");
        ajouter_bulletin.setActionCommand("ajouter_bulletin");
        ajouter_bulletin.addActionListener(menuItemListener);
        menu2.add(ajouter_bulletin);
        
        JMenuItem ajouter_appreciation = new JMenuItem("ajouter_appreciation");
        ajouter_appreciation.setActionCommand("ajouter_appreciation");
        ajouter_appreciation.addActionListener(menuItemListener);
        menu2.add(ajouter_appreciation);
        
        JMenuItem ajouter_semestre = new JMenuItem("ajouter_semestre");
        ajouter_semestre.setActionCommand("ajouter_semestre");
        ajouter_semestre.addActionListener(menuItemListener);
        menu2.add(ajouter_semestre);


        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.gray);
        this.setJMenuBar(menu);
        this.add(content);

        this.setVisible(true);
    }

    class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
                case "ajouter_eleve":
                    addStudent();
                    break;
                case "ajouter_annee":
                    addYear();
                    break;
                case "ajouter_matiere":
                    addField();
                    break;
                case "ajouter_niveau":
                    addLevel();
                    break;
                case "ajouter_classe":
                    addClass();
                    break;
                case "ajouter_prof":
                    addTeacher();
                    break;
                case "ajouter_cours":
                    addCourse();
                    break;
                case "ajouter_note":
                    addGrade();
                    break;
                case "ajouter_bulletin":
                    addReportCard();
                    break;
                case "ajouter_appreciation":
                    addReportCardDetail();
                    break;
                case "ajouter_semestre":
                    addTerm();
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    private void addStudent() {
        JTextField nom = new JTextField();
        JTextField prenom = new JTextField();
        
        ClasseDAO classDAO = (ClasseDAO) DAOFactory.getClassDAO();
        ArrayList<Classe> options = classDAO.getAll();
        JComboBox<Classe> classe;
        classe = new JComboBox<>(options.toArray(new Classe[options.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Nom de l'eleve"));
        panel.add(nom);
        panel.add(new JLabel("Prénom de l'eleve"));
        panel.add(prenom);
        panel.add(new JLabel("Classe"));
        panel.add(classe);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            StudentDAO studentDAO = (StudentDAO) DAOFactory.getStudentDAO();
            
            studentDAO.create(new Student(0, nom.getText(), prenom.getText(), (int) ((Classe) classe.getSelectedItem()).getId()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addYear() {
        JTextField year = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Annee (entier)"));
        panel.add(year);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            AcademicYearDAO DAO = (AcademicYearDAO) DAOFactory.getAcademicYearDAO();
            
            DAO.create(new AcademicYear(Integer.parseInt(year.getText())));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addField() {
        JTextField name = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Nom de la matiere"));
        panel.add(name);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            FieldDAO DAO = (FieldDAO) DAOFactory.getFieldDAO();
            
            DAO.create(new Field(0, name.getText()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addLevel() {
        JTextField name = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Nom du niveau"));
        panel.add(name);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            LevelDAO DAO = (LevelDAO) DAOFactory.getLevelDAO();
            
            DAO.create(new Level(0, name.getText()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addClass() {
        JTextField nom = new JTextField();
        
        LevelDAO levelDAO = (LevelDAO) DAOFactory.getLevelDAO();
        ArrayList<Level> optionsNiveau = levelDAO.getAll();
        JComboBox<Level> niveau;
        niveau = new JComboBox<>(optionsNiveau.toArray(new Level[optionsNiveau.size()]));
        
        AcademicYearDAO academicYearDAO = (AcademicYearDAO) DAOFactory.getAcademicYearDAO();
        ArrayList<AcademicYear> optionsAnnee = academicYearDAO.getAll();
        JComboBox<AcademicYear> annee;
        annee = new JComboBox<>(optionsAnnee.toArray(new AcademicYear[optionsAnnee.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Nom de la classe"));
        panel.add(nom);
        panel.add(new JLabel("Niveau"));
        panel.add(niveau);
        panel.add(new JLabel("Annee"));
        panel.add(annee);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ClasseDAO DAO = (ClasseDAO) DAOFactory.getClassDAO();
            
            DAO.create(new Classe(0, nom.getText(), (int) ((Classe) niveau.getSelectedItem()).getId(), (int) ((Classe) annee.getSelectedItem()).getId()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addTeacher() {
        JTextField nom = new JTextField();
        JTextField prenom = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Nom"));
        panel.add(nom);
        panel.add(new JLabel("Prenom"));
        panel.add(prenom);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            TeacherDAO DAO = (TeacherDAO) DAOFactory.getTeacherDAO();
            
            DAO.create(new Teacher(0, nom.getText(), prenom.getText()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addCourse() {
        TeacherDAO teacherDAO = (TeacherDAO) DAOFactory.getTeacherDAO();
        ArrayList<Teacher> optionsProf = teacherDAO.getAll();
        JComboBox<Teacher> prof;
        prof = new JComboBox<>(optionsProf.toArray(new Teacher[optionsProf.size()]));
        
        FieldDAO fieldDAO = (FieldDAO) DAOFactory.getFieldDAO();
        ArrayList<Field> optionsMatiere = fieldDAO.getAll();
        JComboBox<Field> matiere;
        matiere = new JComboBox<>(optionsMatiere.toArray(new Field[optionsMatiere.size()]));
        
        ClasseDAO classDAO = (ClasseDAO) DAOFactory.getClassDAO();
        ArrayList<Classe> optionsClasse = classDAO.getAll();
        JComboBox<Classe> classe;
        classe = new JComboBox<>(optionsClasse.toArray(new Classe[optionsClasse.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Prof"));
        panel.add(prof);
        panel.add(new JLabel("Matiere"));
        panel.add(matiere);
        panel.add(new JLabel("Classe"));
        panel.add(classe);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            CourseDAO DAO = (CourseDAO) DAOFactory.getCourseDAO();
            DAO.create(new Course(0, (int) ((Teacher) prof.getSelectedItem()).getId(), (int) ((Field) matiere.getSelectedItem()).getId(), (int) ((Classe) classe.getSelectedItem()).getId()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addGrade() {
        JTextField note = new JTextField();
        JTextField commentaire = new JTextField();
        
        ReportCardDetailDAO reportCardDetailDAO = (ReportCardDetailDAO) DAOFactory.getReportCardDetailDAO();
        ArrayList<ReportCardDetail> optionsRC = reportCardDetailDAO.getAll();
        JComboBox<ReportCardDetail> rcdetail;
        rcdetail = new JComboBox<>(optionsRC.toArray(new ReportCardDetail[optionsRC.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Note"));
        panel.add(note);
        panel.add(new JLabel("Appreciation"));
        panel.add(commentaire);
        panel.add(new JLabel("Detail"));
        panel.add(rcdetail);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            GradeDAO DAO = (GradeDAO) DAOFactory.getGradeDAO();
            
            DAO.create(new Grade(0, Float.parseFloat(note.getText()), commentaire.getText(), (int) ((ReportCardDetail) rcdetail.getSelectedItem()).getId()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addReportCard() {
        JTextField appreciation = new JTextField();
        JTextField commentaire = new JTextField();
        
        TermDAO termDAO = (TermDAO) DAOFactory.getTermDAO();
        ArrayList<Term> optionsSemestre = termDAO.getAll();
        JComboBox<Term> semestre;
        semestre = new JComboBox<>(optionsSemestre.toArray(new Term[optionsSemestre.size()]));
        
        StudentDAO studentDAO = (StudentDAO) DAOFactory.getStudentDAO();
        ArrayList<Student> optionsEtudiant = studentDAO.getAll();
        JComboBox<Student> etudiant;
        etudiant = new JComboBox<>(optionsEtudiant.toArray(new Student[optionsEtudiant.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Appreciation"));
        panel.add(appreciation);
        panel.add(new JLabel("Semestre"));
        panel.add(semestre);
        panel.add(new JLabel("Etudiant"));
        panel.add(etudiant);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ReportCardDAO DAO = (ReportCardDAO) DAOFactory.getReportCardDAO();
            
            DAO.create(new ReportCard(0, (int) ((Term) semestre.getSelectedItem()).getId(), (int) ((Student) etudiant.getSelectedItem()).getId(), appreciation.getText()
            ));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addReportCardDetail() {
        JTextField commentaire = new JTextField();
        
        ReportCardDAO reportCardDAO = (ReportCardDAO) DAOFactory.getReportCardDAO();
        ArrayList<ReportCard> optionsRC = reportCardDAO.getAll();
        JComboBox<ReportCard> rc;
        rc = new JComboBox<>(optionsRC.toArray(new ReportCard[optionsRC.size()]));
        
        
        CourseDAO courseDAO = (CourseDAO) DAOFactory.getCourseDAO();
        ArrayList<Course> optionsCours = courseDAO.getAll();
        JComboBox<Course> cours;
        cours = new JComboBox<>(optionsCours.toArray(new Course[optionsCours.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Commentaire"));
        panel.add(commentaire);
        panel.add(new JLabel("Bulletin"));
        panel.add(rc);
        panel.add(new JLabel("Classe"));
        panel.add(cours);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ReportCardDetailDAO DAO = (ReportCardDetailDAO) DAOFactory.getReportCardDetailDAO();
            
            DAO.create(new ReportCardDetail(0, (int) ((ReportCard) rc.getSelectedItem()).getId(), (int) ((Course) cours.getSelectedItem()).getId(), commentaire.getText()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
    
    private void addTerm() {
        JTextField numero = new JTextField();
        JTextField debut = new JTextField();
        JTextField fin = new JTextField();

        AcademicYearDAO academicYearDAO = (AcademicYearDAO) DAOFactory.getAcademicYearDAO();
        ArrayList<AcademicYear> optionsAnnee = academicYearDAO.getAll();
        JComboBox<AcademicYear> annee;
        annee = new JComboBox<>(optionsAnnee.toArray(new AcademicYear[optionsAnnee.size()]));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        panel.add(new JLabel("Numero du semestre (1/2)"));
        panel.add(numero);
        panel.add(new JLabel("Date debut"));
        panel.add(debut);
        panel.add(new JLabel("Date fin"));
        panel.add(fin);
        panel.add(new JLabel("Annee academique"));
        panel.add(annee);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            TermDAO DAO = (TermDAO) DAOFactory.getTermDAO();
            
            DAO.create(new Term(0, Integer.parseInt(numero.getText()), debut.getText(), fin.getText(), (int) ((Classe) annee.getSelectedItem()).getId()));
            System.out.println("Ajout reussi");
        } else {
            System.out.println("Cancelled");
        }
    }
}
