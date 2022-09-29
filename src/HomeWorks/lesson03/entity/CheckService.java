package HomeWorks.lesson03.entity;

import HomeWorks.lesson03.MainInheritance;
public class CheckService{
    public void inputString(User currentUser) {
        System.out.print(currentUser.getName() + " (" + currentUser.getClassShort(currentUser.getClass().getName()) + "), ");
        if ( currentUser instanceof User) {
            ((User)currentUser).write();
        }
        if ( currentUser instanceof Support) {
            MainInheritance.stringIsOk = ((Support)currentUser).checkString(MainInheritance.stringForCheck);
        }
        if ( currentUser instanceof Admin) {
            ((Admin)currentUser).clearIfWrong(MainInheritance.stringIsOk);
        }
    }
}
