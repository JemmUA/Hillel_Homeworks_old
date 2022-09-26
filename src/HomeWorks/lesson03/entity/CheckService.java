package HomeWorks.lesson03.entity;

import HomeWorks.lesson03.mainInheritance;
public class CheckService{
    public void inputString(User currentUser) {
        System.out.print(currentUser.getName() + " (" + currentUser.getClassShort(currentUser.getClass().getName()) + "), ");
        if ( currentUser instanceof User) {
            ((User)currentUser).write();
        }
        if ( currentUser instanceof Support) {
            mainInheritance.stringIsOk = ((Support)currentUser).checkString(mainInheritance.stringForCheck);
        }
        if ( currentUser instanceof Admin) {
            ((Admin)currentUser).clearIfWrong(mainInheritance.stringIsOk);
        }
    }
}
