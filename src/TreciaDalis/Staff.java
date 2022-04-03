package TreciaDalis;

import java.util.Arrays;

public class Staff {
    StaffMember[] staffList;

    public void addStaffMember(StaffMember staff){
        this.staffList = Arrays.copyOf(this.staffList, this.staffList.length + 1);
        this.staffList[staffList.length - 1] = staff;

    }

    public double payDay(){
        double total_sum = 0;
        for(StaffMember member : this.staffList){
            System.out.println(member.name + " " + member.surname + " " + member.pay() + "e");
            total_sum += member.pay();
        }
        return total_sum;
    }
}
