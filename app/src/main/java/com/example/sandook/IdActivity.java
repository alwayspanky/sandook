package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sandook.Adapter.DrivingAdapter;
import com.example.sandook.Adapter.IdsAdapter;
import com.example.sandook.Adapter.PassportAdapter;
import com.example.sandook.Adapter.SocialAdapter;
import com.example.sandook.Adapter.TaxAdapter;
import com.example.sandook.Database.Model.DrivingModel;
import com.example.sandook.Database.Model.IdCardModel;
import com.example.sandook.Database.Model.PassportModel;
import com.example.sandook.Database.Model.SocialModel;
import com.example.sandook.Database.Model.TaxModel;
import com.example.sandook.Database.PassViewModel;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class IdActivity extends AppCompatActivity {

    public static final int ADD_IDCARD_REQUEST = 1;
    public static final int ADD_PASSPORT_REQUEST = 2;
    public static final int ADD_DRIVING_REQUEST = 3;
    public static final int ADD_TAX_REQUEST = 4;
    public static final int ADD_SOCIAL_REQUEST = 5;
    public static final int EDIT_IDCARD_REQUEST = 6;
    public static final int EDIT_PASSPORT_REQUEST = 7;
    public static final int EDIT_DRIVING_REQUEST = 8;
    public static final int EDIT_TAX_REQUEST = 9;
    public static final int EDIT_SOCIAL_REQUEST = 10;

    Toolbar toolbar;
    private  FloatingActionButton  btnFab1, btnFab2, btnFab3, btnFab4, btnFab5;
    RecyclerView recyclerView1,recyclerView2,recyclerView3,recyclerView4,recyclerView5;
    PassViewModel passViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        btnFab1 = findViewById(R.id.id_fab1);
        btnFab2 = findViewById(R.id.id_fab2);
        btnFab3 = findViewById(R.id.id_fab3);
        btnFab4 = findViewById(R.id.id_fab4);
        btnFab5 = findViewById(R.id.id_fab5);

        btnFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idCard = new Intent(IdActivity.this, IdCardActivity.class);
                startActivityForResult(idCard,ADD_IDCARD_REQUEST);
            }
        });

        btnFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idDriving = new Intent(IdActivity.this, DrivingActivity.class);
                startActivityForResult(idDriving,ADD_DRIVING_REQUEST);
            }
        });

        btnFab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idPassport = new Intent(IdActivity.this, PassportActivity.class);
                startActivityForResult(idPassport,ADD_PASSPORT_REQUEST);
            }
        });

        btnFab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idPan = new Intent(IdActivity.this, TaxActivity.class);
                startActivityForResult(idPan,ADD_TAX_REQUEST);
            }
        });

        btnFab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idSocial = new Intent(IdActivity.this, SocialSecurityActivity.class);
                startActivityForResult(idSocial,ADD_SOCIAL_REQUEST);
            }
        });



        toolbar = findViewById(R.id.idToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView1 = findViewById(R.id.recycler_IdCard);
        recyclerView2 = findViewById(R.id.recycler_passport);
        recyclerView3 = findViewById(R.id.recycler_driving);
        recyclerView4 = findViewById(R.id.recycler_tax);
        recyclerView5 = findViewById(R.id.recycler_social);

        passViewModel = new ViewModelProvider(this).get(PassViewModel.class);

        //Id card view
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);
        final IdsAdapter idsAdapter = new IdsAdapter();
        recyclerView1.setAdapter(idsAdapter);
        passViewModel.getAllIdCards().observe(this, new Observer<List<IdCardModel>>() {
            @Override
            public void onChanged(List<IdCardModel> idCardModels) {
                idsAdapter.setIds(idCardModels);
            }
        });

        idsAdapter.setOnItemclickListener(new IdsAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(IdCardModel id) {
                Intent idIntent = new Intent(IdActivity.this,IdCardActivity.class);
                idIntent.putExtra(IdCardActivity.EXTRA_I_ID,id.getId());
                idIntent.putExtra(IdCardActivity.EXTRA_I_NAME,id.getiName());
                idIntent.putExtra(IdCardActivity.EXTRA_I_GENDER,id.getiGender());
                idIntent.putExtra(IdCardActivity.EXTRA_I_DOB,id.getiDob());
                idIntent.putExtra(IdCardActivity.EXTRA_I_COUNTRY,id.getiCountry());
                idIntent.putExtra(IdCardActivity.EXTRA_I_NUMBER,id.getiNumber());
                idIntent.putExtra(IdCardActivity.EXTRA_I_ISSUEDATE,id.getiIssueDate());
                idIntent.putExtra(IdCardActivity.EXTRA_I_EXPRY,id.getiExpirationDate());
                idIntent.putExtra(IdCardActivity.EXTRA_I_ADDRESS,id.getiAddress());
                startActivityForResult(idIntent,EDIT_IDCARD_REQUEST);
            }
        });

        //Passport model view
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setHasFixedSize(true);
        final PassportAdapter passportAdapter = new PassportAdapter();
        recyclerView2.setAdapter(passportAdapter);
        passViewModel.getAllPassports().observe(this, new Observer<List<PassportModel>>() {
            @Override
            public void onChanged(List<PassportModel> passportModels) {
                passportAdapter.setPassports(passportModels);
            }
        });

        passportAdapter.setOnItemclickListener(new PassportAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(PassportModel passport) {
                Intent passIntent = new Intent(IdActivity.this, PassportActivity.class );
                passIntent.putExtra(PassportActivity.EXTRA_P_ID,passport.getId());
                passIntent.putExtra(PassportActivity.EXTRA_P_NAME,passport.getpName());
                passIntent.putExtra(PassportActivity.EXTRA_P_GENDER,passport.getpGender());
                passIntent.putExtra(PassportActivity.EXTRA_P_DOB,passport.getpDob());
                passIntent.putExtra(PassportActivity.EXTRA_P_COUNTRY,passport.getpCountry());
                passIntent.putExtra(PassportActivity.EXTRA_P_NUMBER,passport.getpNumber());
                passIntent.putExtra(PassportActivity.EXTRA_P_ISSUEDATE,passport.getpIssueDate());
                passIntent.putExtra(PassportActivity.EXTRA_P_EXPRY,passport.getpExpirationDate());
                passIntent.putExtra(PassportActivity.EXTRA_P_PLACE,passport.getpPlaceIssue());
                startActivityForResult(passIntent,EDIT_PASSPORT_REQUEST);

            }
        });

        //Driving model view
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setHasFixedSize(true);
        final DrivingAdapter drivingAdapter = new DrivingAdapter();
        recyclerView3.setAdapter(drivingAdapter);
        passViewModel.getAllDrivings().observe(this, new Observer<List<DrivingModel>>() {
            @Override
            public void onChanged(List<DrivingModel> drivingModels) {
                drivingAdapter.setDrivings(drivingModels);
            }
        });

        drivingAdapter.setOnItemclickListener(new DrivingAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(DrivingModel driving) {
                Intent driveIntent = new Intent(IdActivity.this,DrivingActivity.class);
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_ID,driving.getId());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_NAME,driving.getdName());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_GENDER,driving.getdGender());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_DOB,driving.getdDob());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_COUNTRY,driving.getdCountry());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_NUMBER,driving.getdNumber());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_ISSUEDATE,driving.getdIssueDate());
                driveIntent.putExtra(DrivingActivity.EXTRA_DR_EXPRY,driving.getdExpirationDate());
                startActivityForResult(driveIntent,EDIT_DRIVING_REQUEST);
            }
        });

        //Tax view Model
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        recyclerView4.setHasFixedSize(true);
        final TaxAdapter taxAdapter = new TaxAdapter();
        recyclerView4.setAdapter(taxAdapter);
        passViewModel.getAllTaxes().observe(this, new Observer<List<TaxModel>>() {
            @Override
            public void onChanged(List<TaxModel> taxModels) {
                taxAdapter.setTaxes(taxModels);
            }
        });

        taxAdapter.setOnItemclickListener(new TaxAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(TaxModel taxModel) {
                Intent taxIntent = new Intent(IdActivity.this, TaxActivity.class);
                taxIntent.putExtra(TaxActivity.EXTRA_T_ID,taxModel.getId());
                taxIntent.putExtra(TaxActivity.EXTRA_T_NAME,taxModel.getName());
                taxIntent.putExtra(TaxActivity.EXTRA_T_COUNTRY,taxModel.getCountry());
                taxIntent.putExtra(TaxActivity.EXTRA_T_NUMBER,taxModel.getNumber());
                startActivityForResult(taxIntent, EDIT_TAX_REQUEST);
            }
        });

        //Social model view
        recyclerView5.setLayoutManager(new LinearLayoutManager(this));
        recyclerView5.setHasFixedSize(true);
        final SocialAdapter socialAdapter = new SocialAdapter();
        recyclerView5.setAdapter(socialAdapter);
        passViewModel.getAllSocials().observe(this, new Observer<List<SocialModel>>() {
            @Override
            public void onChanged(List<SocialModel> socialModels) {
                socialAdapter.setSocials(socialModels);
            }
        });

        socialAdapter.setOnItemClickListener(new SocialAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(SocialModel social) {
                Intent socialIntent = new Intent(IdActivity.this,SocialSecurityActivity.class);
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_ID, social.getId());
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_NAME, social.getName());
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_GENDER, social.getGender());
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_DOB, social.getDob());
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_COUNTRY, social.getCountry());
                socialIntent.putExtra(SocialSecurityActivity.EXTRA_S_NUMBER, social.getNumber());
                startActivityForResult(socialIntent,EDIT_SOCIAL_REQUEST);

            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                passViewModel.deleteIdCard(idsAdapter.getIdsAt(viewHolder.getAdapterPosition()));
                passViewModel.deletePassport(passportAdapter.getPassportAt(viewHolder.getAdapterPosition()));
                passViewModel.deleteDriving(drivingAdapter.getDrivingAt(viewHolder.getAdapterPosition()));
                passViewModel.deleteTax(taxAdapter.getTaxesAt(viewHolder.getAdapterPosition()));
                passViewModel.deleteSocial(socialAdapter.getSocialAt(viewHolder.getAdapterPosition()));
                Toast.makeText(IdActivity.this,"Item Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == ADD_IDCARD_REQUEST && resultCode == RESULT_OK){

            String iName = data.getStringExtra(IdCardActivity.EXTRA_I_NAME);
            String iGender = data.getStringExtra(IdCardActivity.EXTRA_I_GENDER);
            String iDob = data.getStringExtra(IdCardActivity.EXTRA_I_DOB);
            String iCountry = data.getStringExtra(IdCardActivity.EXTRA_I_COUNTRY);
            String iNumber = data.getStringExtra(IdCardActivity.EXTRA_I_NUMBER);
            String iIssueDate = data.getStringExtra(IdCardActivity.EXTRA_I_ISSUEDATE);
            String iExpirationDate = data.getStringExtra(IdCardActivity.EXTRA_I_EXPRY);
            String iAddress = data.getStringExtra(IdCardActivity.EXTRA_I_ADDRESS);

            IdCardModel idCardModel = new IdCardModel(iName,iGender,iDob,iCountry,iNumber,iIssueDate,iExpirationDate,iAddress);
            passViewModel.insertIdCard(idCardModel);

            Toast.makeText(this,"Id inserted",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_IDCARD_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(IdCardActivity.EXTRA_I_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String iName = data.getStringExtra(IdCardActivity.EXTRA_I_NAME);
            String iGender = data.getStringExtra(IdCardActivity.EXTRA_I_GENDER);
            String iDob = data.getStringExtra(IdCardActivity.EXTRA_I_DOB);
            String iCountry = data.getStringExtra(IdCardActivity.EXTRA_I_COUNTRY);
            String iNumber = data.getStringExtra(IdCardActivity.EXTRA_I_NUMBER);
            String iIssueDate = data.getStringExtra(IdCardActivity.EXTRA_I_ISSUEDATE);
            String iExpirationDate = data.getStringExtra(IdCardActivity.EXTRA_I_EXPRY);
            String iAddress = data.getStringExtra(IdCardActivity.EXTRA_I_ADDRESS);

            IdCardModel idCardModel = new IdCardModel(iName,iGender,iDob,iCountry,iNumber,iIssueDate,iExpirationDate,iAddress);
            idCardModel.setId(id);
            passViewModel.updateIdCard(idCardModel);

            Toast.makeText(this,"Id updated",Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == ADD_PASSPORT_REQUEST && resultCode == RESULT_OK){

            String passName = data.getStringExtra(PassportActivity.EXTRA_P_NAME);
            String passGender = data.getStringExtra(PassportActivity.EXTRA_P_GENDER);
            String passDob = data.getStringExtra(PassportActivity.EXTRA_P_DOB);
            String passCountry = data.getStringExtra(PassportActivity.EXTRA_P_COUNTRY);
            String passNumber = data.getStringExtra(PassportActivity.EXTRA_P_NUMBER);
            String passIssueDate = data.getStringExtra(PassportActivity.EXTRA_P_ISSUEDATE);
            String passExpirationDate = data.getStringExtra(PassportActivity.EXTRA_P_EXPRY);
            String passPlace = data.getStringExtra(PassportActivity.EXTRA_P_PLACE);

            PassportModel passportModel = new PassportModel(passName,passGender,passDob,passCountry,passNumber,passIssueDate,passExpirationDate,passPlace);
            passViewModel.insertPassport(passportModel);

            Toast.makeText(this,"Passport inserted",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_PASSPORT_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(PassportActivity.EXTRA_P_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String passName = data.getStringExtra(PassportActivity.EXTRA_P_NAME);
            String passGender = data.getStringExtra(PassportActivity.EXTRA_P_GENDER);
            String passDob = data.getStringExtra(PassportActivity.EXTRA_P_DOB);
            String passCountry = data.getStringExtra(PassportActivity.EXTRA_P_COUNTRY);
            String passNumber = data.getStringExtra(PassportActivity.EXTRA_P_NUMBER);
            String passIssueDate = data.getStringExtra(PassportActivity.EXTRA_P_ISSUEDATE);
            String passExpirationDate = data.getStringExtra(PassportActivity.EXTRA_P_EXPRY);
            String passPlace = data.getStringExtra(PassportActivity.EXTRA_P_PLACE);

            PassportModel passportModel = new PassportModel(passName,passGender,passDob,passCountry,passNumber,passIssueDate,passExpirationDate,passPlace);
            passportModel.setId(id);
            passViewModel.updatePassport(passportModel);

            Toast.makeText(this,"Passport updated",Toast.LENGTH_SHORT).show();

        }
        else if(requestCode == ADD_DRIVING_REQUEST && resultCode == RESULT_OK){

            String driveName = data.getStringExtra(DrivingActivity.EXTRA_DR_NAME);
            String driveGender = data.getStringExtra(DrivingActivity.EXTRA_DR_GENDER);
            String driveDob = data.getStringExtra(DrivingActivity.EXTRA_DR_DOB);
            String driveCountry = data.getStringExtra(DrivingActivity.EXTRA_DR_COUNTRY);
            String driveNumber = data.getStringExtra(DrivingActivity.EXTRA_DR_NUMBER);
            String driveIssueDate = data.getStringExtra(DrivingActivity.EXTRA_DR_ISSUEDATE);
            String driveExpirationDate = data.getStringExtra(DrivingActivity.EXTRA_DR_EXPRY);

            DrivingModel drivingModel = new DrivingModel(driveName,driveGender,driveDob,driveCountry,driveNumber,driveIssueDate,driveExpirationDate);
            passViewModel.insertDriving(drivingModel);

            Toast.makeText(this,"Driving inserted",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_DRIVING_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(DrivingActivity.EXTRA_DR_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String driveName = data.getStringExtra(DrivingActivity.EXTRA_DR_NAME);
            String driveGender = data.getStringExtra(DrivingActivity.EXTRA_DR_GENDER);
            String driveDob = data.getStringExtra(DrivingActivity.EXTRA_DR_DOB);
            String driveCountry = data.getStringExtra(DrivingActivity.EXTRA_DR_COUNTRY);
            String driveNumber = data.getStringExtra(DrivingActivity.EXTRA_DR_NUMBER);
            String driveIssueDate = data.getStringExtra(DrivingActivity.EXTRA_DR_ISSUEDATE);
            String driveExpirationDate = data.getStringExtra(DrivingActivity.EXTRA_DR_EXPRY);

            DrivingModel drivingModel = new DrivingModel(driveName,driveGender,driveDob,driveCountry,driveNumber,driveIssueDate,driveExpirationDate);
            drivingModel.setId(id);
            passViewModel.updateDriving(drivingModel);

            Toast.makeText(this,"Driving updated",Toast.LENGTH_SHORT).show();

        }
        else if(requestCode == ADD_TAX_REQUEST && resultCode == RESULT_OK){

            String tName = data.getStringExtra(TaxActivity.EXTRA_T_NAME);
            String tCountry = data.getStringExtra(TaxActivity.EXTRA_T_COUNTRY);
            String tNumber = data.getStringExtra(TaxActivity.EXTRA_T_NUMBER);

            TaxModel taxModel = new TaxModel(tName,tCountry,tNumber);
            passViewModel.insertTax(taxModel);

            Toast.makeText(this,"Tax inserted",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_TAX_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(TaxActivity.EXTRA_T_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String tName = data.getStringExtra(TaxActivity.EXTRA_T_NAME);
            String tCountry = data.getStringExtra(TaxActivity.EXTRA_T_COUNTRY);
            String tNumber = data.getStringExtra(TaxActivity.EXTRA_T_NUMBER);

            TaxModel taxModel = new TaxModel(tName,tCountry,tNumber);
            taxModel.setId(id);
            passViewModel.updateTax(taxModel);

            Toast.makeText(this,"Tax updated",Toast.LENGTH_SHORT).show();

        }
        else if(requestCode == ADD_SOCIAL_REQUEST && resultCode == RESULT_OK){

            String sName = data.getStringExtra(SocialSecurityActivity.EXTRA_S_NAME);
            String sGender = data.getStringExtra(SocialSecurityActivity.EXTRA_S_GENDER);
            String sDob = data.getStringExtra(SocialSecurityActivity.EXTRA_S_DOB);
            String sCountry = data.getStringExtra(SocialSecurityActivity.EXTRA_S_COUNTRY);
            String sNumber = data.getStringExtra(SocialSecurityActivity.EXTRA_S_NUMBER);

            SocialModel socialModel = new SocialModel(sName,sGender,sDob,sCountry,sNumber);
            passViewModel.insertSocial(socialModel);

            Toast.makeText(this,"Social inserted",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_SOCIAL_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(SocialSecurityActivity.EXTRA_S_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String sName = data.getStringExtra(SocialSecurityActivity.EXTRA_S_NAME);
            String sGender = data.getStringExtra(SocialSecurityActivity.EXTRA_S_GENDER);
            String sDob = data.getStringExtra(SocialSecurityActivity.EXTRA_S_DOB);
            String sCountry = data.getStringExtra(SocialSecurityActivity.EXTRA_S_COUNTRY);
            String sNumber = data.getStringExtra(SocialSecurityActivity.EXTRA_S_NUMBER);

            SocialModel socialModel = new SocialModel(sName,sGender,sDob,sCountry,sNumber);
            socialModel.setId(id);
            passViewModel.updateSocial(socialModel);

            Toast.makeText(this,"Social updated",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this,"Item not inserted",Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
