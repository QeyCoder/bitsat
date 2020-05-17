package roundzero.day31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
public class BloodDonation {
    public static void main(String[] args) throws IOException {
 BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
 int n = Integer.parseInt(inputReader.readLine());

 for (int i = 0; i < n; i++) {
     String donor = inputReader.readLine();
     String patient = inputReader.readLine();
     Queue<Donor> donorQueue = new LinkedList<>();
     Queue<Patient> patientQueue = new LinkedList<>();
     Stream<Character> donorStream = donor.chars().mapToObj(c -> (char) c);
     final int[] count = {0};
     donorStream.forEach(character -> donorQueue.add(new Donor(character, count[0]++)));
     Stream<Character> patientStream = patient.chars().mapToObj(c -> (char) c);
     patientStream.forEach(character -> patientQueue.add(new Patient(character)));
     System.out.println(solution(donorQueue, patientQueue));
 }
    }
    private static int solution(Queue<Donor> donorQueue, Queue<Patient> patientQueue) {
 int initialSize = patientQueue.size();
 int size = 0;
 while (!patientQueue.isEmpty() && !donorQueue.isEmpty()) {
     Donor donor = donorQueue.poll();
     Patient patient = patientQueue.peek();
     if (donor.index == patient.faced) {
  size++;
  patientQueue.poll();
     }
     if (donationPossible(donor, patient)) {
  if (!patient.donate()) {
      patientQueue.poll();
  }
     } else {
  if (patient.faced == -1) {
      patient.faced(donor.index);
  }
  donorQueue.add(donor);
     }
 }
 return initialSize - size;
    }
    private static boolean donationPossible(Donor donor, Patient patient) {
 if (patient.bloodGrp == 'A' && (donor.bloodGrp == 'O' || donor.bloodGrp == 'A')) {
     return true;
 } else if (patient.bloodGrp == 'B' && (donor.bloodGrp == 'O' || donor.bloodGrp == 'B')) {
     return true;
 } else if (patient.bloodGrp == 'C') {
     return true;
 } else if (patient.bloodGrp == 'O' && donor.bloodGrp == 'O') {
     return true;
 }
 return false;
    }
    static class Patient {
 Character bloodGrp;
 int count;
 int faced = -1;
 public Patient(Character bloodGrp) {
     this.bloodGrp = bloodGrp;
 }
 public boolean donate() {
     count++;
     if (count == 3) {
  return false;
     }
     return true;
 }
 public void faced(int index) {
     this.faced = index;
 }
    }
    static class Donor {
 Character bloodGrp;
 int index;
 public Donor(Character bloodGrp, int i) {
     this.bloodGrp = bloodGrp;
     this.index = i;
 }
    }
}
