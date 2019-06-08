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
        this.showLogin();
        this.buildInterface();
    }

    private void setup() {
        this.setTitle("Gestion d'école - Déconnecté");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.setVisible(true);
    }

    private void showLogin() {
        JLabel coLabel = new JLabel("Connexion");
        JTextField nom = new JTextField();
        JTextField prenom = new JTextField();

        JPanel window = new JPanel(new GridLayout(0, 1));
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.gray);
        window.add(coLabel);
        window.add(new JLabel("Nom"));
        window.add(nom);
        window.add(new JLabel("Prenom"));
        window.add(prenom);

        boolean success = false;

        while (!success) {
            int result = JOptionPane.showConfirmDialog(null, window, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                TeacherDAO DAO = (TeacherDAO) DAOFactory.getTeacherDAO();

                success = DAO.findIfExistsFromName(nom.getText(), prenom.getText());
                if (success) {
                    System.out.println("Connexion reussie");
                    this.setTitle("Gestion d'école - Connecté en tant que " + nom.getText() + " " + prenom.getText());
                }
            } else {
                System.out.println("Cancelled");
                System.exit(0);
            }
        }

        this.setVisible(true);
    }

    private void buildInterface() {
        menu = new JMenuBar();
        menuItemListener = new MenuItemListener();
        content = new JPanel();
        //content.setBackground(Color.green);

        // Create menus
        JMenu menu1 = new JMenu("Modifier");
        JMenu menu2 = new JMenu("Ajouter");
        JMenu menu3 = new JMenu("Supprimer");

        // Create options
        // MODIFY
        JMenuItem modif_eleve = new JMenuItem("modif_eleve");
        modif_eleve.setActionCommand("modif_eleve");
        modif_eleve.addActionListener(menuItemListener);
        menu1.add(modif_eleve);

        JMenuItem modif_cours = new JMenuItem("modif_cours");
        modif_cours.setActionCommand("modif_cours");
        modif_cours.addActionListener(menuItemListener);
        menu1.add(modif_cours);

        JMenuItem modif_appreciation = new JMenuItem("modif_appreciation");
        modif_appreciation.setActionCommand("modif_appreciation");
        modif_appreciation.addActionListener(menuItemListener);
        menu1.add(modif_appreciation);

        JMenuItem modif_bulletin = new JMenuItem("modif_bulletin");
        modif_bulletin.setActionCommand("modif_bulletin");
        modif_bulletin.addActionListener(menuItemListener);
        menu1.add(modif_bulletin);

        // ADD
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
        
        JMenuItem suppr_eleve = new JMenuItem("suppr_eleve");
        suppr_eleve.setActionCommand("suppr_eleve");
        suppr_eleve.addActionListener(menuItemListener);
        menu3.add(suppr_eleve);

        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.white);
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
                case "modif_eleve":
                    selectAndUpdateStudent();
                    break;
                case "modif_cours":
                    selectAndUpdateCourse();
                    break;
                case "modif_appreciation":
                    selectAndUpdateReportCardDetail();
                    break;
                case "modif_bulletin":
                    selectAndUpdateReportCard();
                    break;
                case "suppr_eleve":
                    selectAndDeleteStudent();
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
    
    private void selectAndDeleteStudent() {
        StudentDAO DAO = (StudentDAO) DAOFactory.getStudentDAO();
        ArrayList<Student> options = DAO.getAll();
        JComboBox<Student> listeEtudiants;
        listeEtudiants = new JComboBox<>(options.toArray(new Student[options.size()]));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Quel eleve doit etre retire ?"));
        panel.add(listeEtudiants);

        // SELECT
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Student etu = (Student) listeEtudiants.getSelectedItem();
            String name = etu.getFirstName() + " " + etu.getLastName();
            DAO.delete(etu);
            System.out.println("L'etudiant " + etu + " a ete retire de l'ecole");
        } else {
            System.out.println("Cancelled");
        }
    }

    private void selectAndUpdateStudent() {
        StudentDAO DAO = (StudentDAO) DAOFactory.getStudentDAO();
        ArrayList<Student> options = DAO.getAll();
        JComboBox<Student> listeEtudiants;
        listeEtudiants = new JComboBox<>(options.toArray(new Student[options.size()]));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Quel eleve doit etre modifie ?"));
        panel.add(listeEtudiants);

        // SELECT
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int id = (int) ((Student) listeEtudiants.getSelectedItem()).getId();
            updateStudent(DAO.find(id));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void updateStudent(Student s) {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JTextField nom = new JTextField(s.getLastName());
        JTextField prenom = new JTextField(s.getFirstName());

        ClasseDAO classDAO = (ClasseDAO) DAOFactory.getClassDAO();
        ArrayList<Classe> optionsClasse = classDAO.getAll();
        JComboBox<Classe> classe;
        classe = new JComboBox<>(optionsClasse.toArray(new Classe[optionsClasse.size()]));
        for (int i = 0; i < optionsClasse.size(); i++) {
            System.out.println("i: " + i + ", idClasse: " + optionsClasse.get(i).getId() + ", idClasseEtudiant: " + s.getIdClass());
            if (optionsClasse.get(i).getId() == s.getIdClass()) {
                classe.setSelectedIndex(i);
            }
        }

        panel.add(new JLabel("Nom de l'eleve"));
        panel.add(nom);
        panel.add(new JLabel("Prénom de l'eleve"));
        panel.add(prenom);
        panel.add(new JLabel("Classe"));
        panel.add(classe);

        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            StudentDAO DAO = (StudentDAO) DAOFactory.getStudentDAO();
            DAO.update(new Student(s.getId(), nom.getText(), prenom.getText(), (int) ((Classe) classe.getSelectedItem()).getId()));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void selectAndUpdateCourse() {
        CourseDAO DAO = (CourseDAO) DAOFactory.getCourseDAO();
        ArrayList<Course> options = DAO.getAll();
        JComboBox<Course> liste;
        liste = new JComboBox<>(options.toArray(new Course[options.size()]));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Quel cours doit etre modifie ?"));
        panel.add(liste);

        // SELECT
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int id = (int) ((Course) liste.getSelectedItem()).getId();
            updateCourse(DAO.find(id));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void updateCourse(Course c) {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        TeacherDAO teacherDAO = (TeacherDAO) DAOFactory.getTeacherDAO();
        ArrayList<Teacher> optionsProf = teacherDAO.getAll();
        JComboBox<Teacher> profs;
        profs = new JComboBox<>(optionsProf.toArray(new Teacher[optionsProf.size()]));
        for (int i = 0; i < optionsProf.size(); i++) {
            if (optionsProf.get(i).getId() == c.getIdTeacher()) {
                profs.setSelectedIndex(i);
            }
        }

        FieldDAO fieldDAO = (FieldDAO) DAOFactory.getFieldDAO();
        ArrayList<Field> optionsField = fieldDAO.getAll();
        JComboBox<Field> fields;
        fields = new JComboBox<>(optionsField.toArray(new Field[optionsField.size()]));
        for (int i = 0; i < optionsField.size(); i++) {
            if (optionsField.get(i).getId() == c.getIdField()) {
                fields.setSelectedIndex(i);
            }
        }

        ClasseDAO classDAO = (ClasseDAO) DAOFactory.getClassDAO();
        ArrayList<Classe> optionsClasse = classDAO.getAll();
        JComboBox<Classe> classe;
        classe = new JComboBox<>(optionsClasse.toArray(new Classe[optionsClasse.size()]));
        for (int i = 0; i < optionsClasse.size(); i++) {
            if (optionsClasse.get(i).getId() == c.getIdClass()) {
                classe.setSelectedIndex(i);
            }
        }

        panel.add(new JLabel("Professeur"));
        panel.add(profs);
        panel.add(new JLabel("Matiere"));
        panel.add(fields);
        panel.add(new JLabel("Classe"));
        panel.add(classe);

        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            CourseDAO DAO = (CourseDAO) DAOFactory.getCourseDAO();
            int idTeacher = (int) ((Teacher) profs.getSelectedItem()).getId();
            int idField = (int) ((Field) fields.getSelectedItem()).getId();
            int idClass = (int) ((Classe) classe.getSelectedItem()).getId();
            DAO.update(new Course(c.getId(), idTeacher, idField, idClass));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void selectAndUpdateReportCardDetail() {
        ReportCardDetailDAO DAO = (ReportCardDetailDAO) DAOFactory.getReportCardDetailDAO();
        ArrayList<ReportCardDetail> options = DAO.getAll();
        JComboBox<ReportCardDetail> liste;
        liste = new JComboBox<>(options.toArray(new ReportCardDetail[options.size()]));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Quelle appreciation doit etre modifiee ?"));
        panel.add(liste);

        // SELECT
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int id = (int) ((ReportCardDetail) liste.getSelectedItem()).getId();
            updateReportCardDetail(DAO.find(id));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void updateReportCardDetail(ReportCardDetail rcd) {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JTextField commentaire = new JTextField(rcd.getComment());

        ReportCardDAO ReportCardDAO = (ReportCardDAO) DAOFactory.getReportCardDAO();
        ArrayList<ReportCard> optionsBulletin = ReportCardDAO.getAll();
        System.out.println("hey");
        JComboBox<ReportCard> bulletin;
        bulletin = new JComboBox<>(optionsBulletin.toArray(new ReportCard[optionsBulletin.size()]));
        for (int i = 0; i < optionsBulletin.size(); i++) {
            if (optionsBulletin.get(i).getId() == rcd.getIdRC()) {
                bulletin.setSelectedIndex(i);
            }
        }

        CourseDAO courseDAO = (CourseDAO) DAOFactory.getCourseDAO();
        ArrayList<Course> optionsCourse = courseDAO.getAll();
        JComboBox<Course> cours;
        cours = new JComboBox<>(optionsCourse.toArray(new Course[optionsCourse.size()]));
        for (int i = 0; i < optionsCourse.size(); i++) {
            if (optionsCourse.get(i).getId() == rcd.getIdCourse()) {
                cours.setSelectedIndex(i);
            }
        }

        panel.add(new JLabel("Bulletin"));
        panel.add(bulletin);
        panel.add(new JLabel("Cours"));
        panel.add(cours);
        panel.add(new JLabel("Commentaire"));
        panel.add(commentaire);

        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ReportCardDetailDAO DAO = (ReportCardDetailDAO) DAOFactory.getReportCardDetailDAO();
            int idBulletin = (int) ((ReportCard) bulletin.getSelectedItem()).getId();
            int idCours = (int) ((Course) cours.getSelectedItem()).getId();
            String com = commentaire.getText();
            DAO.update(new ReportCardDetail(rcd.getId(), idBulletin, idCours, com));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void selectAndUpdateReportCard() {
        ReportCardDAO DAO = (ReportCardDAO) DAOFactory.getReportCardDAO();
        ArrayList<ReportCard> options = DAO.getAll();
        JComboBox<ReportCard> liste;
        liste = new JComboBox<>(options.toArray(new ReportCard[options.size()]));

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Quel bulletin doit etre modifie ?"));
        panel.add(liste);

        // SELECT
        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int id = (int) ((ReportCard) liste.getSelectedItem()).getId();
            updateReportCard(DAO.find(id));
        } else {
            System.out.println("Cancelled");
        }
    }

    private void updateReportCard(ReportCard rc) {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JTextField commentaire = new JTextField(rc.getGeneCom());

        TermDAO termDAO = (TermDAO) DAOFactory.getTermDAO();
        ArrayList<Term> optionsTerm = termDAO.getAll();
        JComboBox<Term> semestre;
        semestre = new JComboBox<>(optionsTerm.toArray(new Term[optionsTerm.size()]));
        for (int i = 0; i < optionsTerm.size(); i++) {
            if (optionsTerm.get(i).getId() == rc.getIdTerm()) {
                semestre.setSelectedIndex(i);
            }
        }
        
        StudentDAO studentDAO = (StudentDAO) DAOFactory.getStudentDAO();
        ArrayList<Student> optionsStudent = studentDAO.getAll();
        JComboBox<Student> etudiant;
        etudiant = new JComboBox<>(optionsStudent.toArray(new Student[optionsStudent.size()]));
        for (int i = 0; i < optionsStudent.size(); i++) {
            if (optionsStudent.get(i).getId() == rc.getIdStudent()) {
                etudiant.setSelectedIndex(i);
            }
        }

        panel.add(new JLabel("Semestre"));
        panel.add(semestre);
        panel.add(new JLabel("Etudiant"));
        panel.add(etudiant);
        panel.add(new JLabel("Commentaire"));
        panel.add(commentaire);

        int result = JOptionPane.showConfirmDialog(null, panel, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ReportCardDAO DAO = (ReportCardDAO) DAOFactory.getReportCardDAO();
            int termId = (int) ((Term) semestre.getSelectedItem()).getId();
            int studentId = (int) ((Student) etudiant.getSelectedItem()).getId();
            String com = commentaire.getText();
            DAO.update(new ReportCard(rc.getId(), termId, studentId, com));
        } else {
            System.out.println("Cancelled");
        }
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

            DAO.create(new Classe(0, nom.getText(), (int) ((Level) niveau.getSelectedItem()).getId(), (int) ((AcademicYear) annee.getSelectedItem()).getId()));
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
