/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Doctor;
import DataAcess.DoctorDao;
import java.util.ArrayList;
/**
 *
 * @author ROG
 */
public class DoctorRepository implements IDoctorRepository{
    @Override
    public void addDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().addDoctor(ld);
    }

    @Override
    public void updateDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().updateDoctor(ld);
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().deleteDoctor(ld);
    }

    @Override
    public void searchDoctor(ArrayList<Doctor> ld) {
        DoctorDao.Instance().searchDoctor(ld);
    }
}
