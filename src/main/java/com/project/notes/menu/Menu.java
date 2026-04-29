package com.project.notes.menu;

import com.project.notes.model.Note;
import com.project.notes.model.User;
import com.project.notes.service.NoteService;
import com.project.notes.service.RegisterService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Scanner;

@Service
public class Menu {

    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    private final RegisterService registerService;
    private final NoteService noteService;

    public Menu(RegisterService registerService, NoteService noteService) {
        this.registerService = registerService;
        this.noteService = noteService;
    }

    public void menu() {
        while (choice != 3) {
            System.out.println("\n--- Meny ---");
            System.out.println("1. Registration");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.println("Sign up");
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        User user = registerService.registerUser(username, password);

                        if (user != null) {
                            System.out.println("Your registration is successfully done.");
                            userMenu(user);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Sign in");
                        System.out.print("Enter username: ");
                        String userInput = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String passInput = scanner.nextLine();
                        User inloggedUser = registerService.login(userInput, passInput);

                        if (inloggedUser != null) {
                            System.out.println("You logged in.");
                            userMenu(inloggedUser);
                            continue;
                        }
                        else {
                            System.out.println("Username or password is incorrect. Try again!");
                        }

                        break;
                    }
                    case 3:{
                        continue;
                    }

                    default:
                        System.out.println("Fel!");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }

        }
        scanner.close();

    }


    public void userMenu(User user) {

        while (choice != 4) {
            System.out.println("\n--- My Page ---");
            System.out.println("1. Create a note");
            System.out.println("2. Show notes");
            System.out.println("3. Change password");
            System.out.println("4. Log out");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("Here can you write a note");
                        String noteText = scanner.nextLine();
                        noteService.saveNote(noteText, user);
                        break;
                    }
                    case 2: {
                        System.out.println("Your notes:");
                        List<Note> notes = noteService.findAllNotes(user);
                        int n = 1;
                        for (Note note : notes) {
                            System.out.println(n + ". " + note.getNote());
                            n++;
                        }
                        System.out.println("Chose note:");
                        int selectedNoteIndex = scanner.nextInt();
                        scanner.nextLine();
                        Note selectedNote = notes.get(selectedNoteIndex - 1);
                        System.out.println("C. Change note");
                        System.out.println("D. Delete note");
                        System.out.println("E. Exit");
                        System.out.print("Enter choice: ");

                        String choiceL = scanner.nextLine().toLowerCase();
                        switch (choiceL) {
                            case "c": {
                                System.out.println("Write a text:");
                                String noteUpdate =  scanner.nextLine();
                                selectedNote.setNote(noteUpdate);
                                noteService.updateNote(selectedNote);
                                break;
                            }
                            case "d": {
                                noteService.deleteNote(selectedNote);
                                System.out.println("Your note has been deleted");
                                break;
                            }
                            case "e": {
                                userMenu(user);
                                break;
                            }
                            default:
                                System.out.println("Something went wrong. Try again!");
                                scanner.nextLine();


                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Change password:");
                        System.out.println("Write new password:");
                        String newPassword = scanner.nextLine();
                        if (newPassword== null||newPassword.isBlank()){
                            System.out.println("Invalid input. Try again!");

                        }
                        else {
                            registerService.updatePassword(user, newPassword);
                            System.out.println("Password updated");
                        }


                        break;
                    }
                    case 4: {
                        return;
                    }

                    default:
                        System.out.println("Fel!");
                        break;
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();


            }
        }
    }


    public void noteMenu() {
        System.out.println("User menu");
    }

    public List<Note> printNotes(User user) {
        List<Note> notes = noteService.findAllNotes(user);
        int n = 1;
        for (Note note : notes) {
            System.out.println(n + ". " + note.getNote());
            n++;

        }
        return notes;
    }


}


