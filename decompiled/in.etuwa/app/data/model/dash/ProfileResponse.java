package in.etuwa.app.data.model.dash;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ProfileResponse {
    private final String address1;
    private final String address2;
    private final String address3;
    private final String adharno;
    private final String admission_no;
    private final String bank_accno;
    private final String bank_branch;
    private final boolean bank_edit;
    private final String bank_ifsc_code;
    private final String bank_name;
    private final String bankdetail_status;
    private final String blood_group;
    private final String district;
    private final String dob;
    private final boolean edit_profile;
    private final String email;
    private final String father_name;
    private final String father_occupation;
    private final String gender;
    private final String mother_name;
    private final String mother_occupation;
    private final String name;
    private final String nationality;
    private final String phone_father;
    private final String phone_home;
    private final String phone_mother;
    private final String pin;
    private final boolean profile_edit_live;
    private final String register_no;
    private final String religion;
    private final String state;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFather_name() {
        return this.father_name;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMother_name() {
        return this.mother_name;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPhone_father() {
        return this.phone_father;
    }

    /* renamed from: component13, reason: from getter */
    public final String getFather_occupation() {
        return this.father_occupation;
    }

    /* renamed from: component14, reason: from getter */
    public final String getMother_occupation() {
        return this.mother_occupation;
    }

    /* renamed from: component15, reason: from getter */
    public final String getPhone_mother() {
        return this.phone_mother;
    }

    /* renamed from: component16, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component17, reason: from getter */
    public final String getAddress1() {
        return this.address1;
    }

    /* renamed from: component18, reason: from getter */
    public final String getAddress2() {
        return this.address2;
    }

    /* renamed from: component19, reason: from getter */
    public final String getAddress3() {
        return this.address3;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component20, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* renamed from: component21, reason: from getter */
    public final String getPin() {
        return this.pin;
    }

    /* renamed from: component22, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component23, reason: from getter */
    public final String getPhone_home() {
        return this.phone_home;
    }

    /* renamed from: component24, reason: from getter */
    public final String getBank_name() {
        return this.bank_name;
    }

    /* renamed from: component25, reason: from getter */
    public final String getBank_branch() {
        return this.bank_branch;
    }

    /* renamed from: component26, reason: from getter */
    public final String getBank_accno() {
        return this.bank_accno;
    }

    /* renamed from: component27, reason: from getter */
    public final String getBank_ifsc_code() {
        return this.bank_ifsc_code;
    }

    /* renamed from: component28, reason: from getter */
    public final boolean getBank_edit() {
        return this.bank_edit;
    }

    /* renamed from: component29, reason: from getter */
    public final String getBankdetail_status() {
        return this.bankdetail_status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDob() {
        return this.dob;
    }

    /* renamed from: component30, reason: from getter */
    public final boolean getEdit_profile() {
        return this.edit_profile;
    }

    /* renamed from: component31, reason: from getter */
    public final boolean getProfile_edit_live() {
        return this.profile_edit_live;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReligion() {
        return this.religion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBlood_group() {
        return this.blood_group;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAdharno() {
        return this.adharno;
    }

    /* renamed from: component9, reason: from getter */
    public final String getRegister_no() {
        return this.register_no;
    }

    public final ProfileResponse copy(String name, String gender, String dob, String religion, String admission_no, String nationality, String blood_group, String adharno, String register_no, String father_name, String mother_name, String phone_father, String father_occupation, String mother_occupation, String phone_mother, String email, String address1, String address2, String address3, String district, String pin, String state, String phone_home, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, boolean bank_edit, String bankdetail_status, boolean edit_profile, boolean profile_edit_live) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(dob, "dob");
        Intrinsics.checkNotNullParameter(religion, "religion");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(blood_group, "blood_group");
        Intrinsics.checkNotNullParameter(adharno, "adharno");
        Intrinsics.checkNotNullParameter(register_no, "register_no");
        Intrinsics.checkNotNullParameter(father_name, "father_name");
        Intrinsics.checkNotNullParameter(mother_name, "mother_name");
        Intrinsics.checkNotNullParameter(phone_father, "phone_father");
        Intrinsics.checkNotNullParameter(father_occupation, "father_occupation");
        Intrinsics.checkNotNullParameter(mother_occupation, "mother_occupation");
        Intrinsics.checkNotNullParameter(phone_mother, "phone_mother");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(address1, "address1");
        Intrinsics.checkNotNullParameter(address2, "address2");
        Intrinsics.checkNotNullParameter(address3, "address3");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(pin, "pin");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(phone_home, "phone_home");
        Intrinsics.checkNotNullParameter(bank_name, "bank_name");
        Intrinsics.checkNotNullParameter(bank_branch, "bank_branch");
        Intrinsics.checkNotNullParameter(bank_accno, "bank_accno");
        Intrinsics.checkNotNullParameter(bank_ifsc_code, "bank_ifsc_code");
        Intrinsics.checkNotNullParameter(bankdetail_status, "bankdetail_status");
        return new ProfileResponse(name, gender, dob, religion, admission_no, nationality, blood_group, adharno, register_no, father_name, mother_name, phone_father, father_occupation, mother_occupation, phone_mother, email, address1, address2, address3, district, pin, state, phone_home, bank_name, bank_branch, bank_accno, bank_ifsc_code, bank_edit, bankdetail_status, edit_profile, profile_edit_live);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileResponse)) {
            return false;
        }
        ProfileResponse profileResponse = (ProfileResponse) other;
        return Intrinsics.areEqual(this.name, profileResponse.name) && Intrinsics.areEqual(this.gender, profileResponse.gender) && Intrinsics.areEqual(this.dob, profileResponse.dob) && Intrinsics.areEqual(this.religion, profileResponse.religion) && Intrinsics.areEqual(this.admission_no, profileResponse.admission_no) && Intrinsics.areEqual(this.nationality, profileResponse.nationality) && Intrinsics.areEqual(this.blood_group, profileResponse.blood_group) && Intrinsics.areEqual(this.adharno, profileResponse.adharno) && Intrinsics.areEqual(this.register_no, profileResponse.register_no) && Intrinsics.areEqual(this.father_name, profileResponse.father_name) && Intrinsics.areEqual(this.mother_name, profileResponse.mother_name) && Intrinsics.areEqual(this.phone_father, profileResponse.phone_father) && Intrinsics.areEqual(this.father_occupation, profileResponse.father_occupation) && Intrinsics.areEqual(this.mother_occupation, profileResponse.mother_occupation) && Intrinsics.areEqual(this.phone_mother, profileResponse.phone_mother) && Intrinsics.areEqual(this.email, profileResponse.email) && Intrinsics.areEqual(this.address1, profileResponse.address1) && Intrinsics.areEqual(this.address2, profileResponse.address2) && Intrinsics.areEqual(this.address3, profileResponse.address3) && Intrinsics.areEqual(this.district, profileResponse.district) && Intrinsics.areEqual(this.pin, profileResponse.pin) && Intrinsics.areEqual(this.state, profileResponse.state) && Intrinsics.areEqual(this.phone_home, profileResponse.phone_home) && Intrinsics.areEqual(this.bank_name, profileResponse.bank_name) && Intrinsics.areEqual(this.bank_branch, profileResponse.bank_branch) && Intrinsics.areEqual(this.bank_accno, profileResponse.bank_accno) && Intrinsics.areEqual(this.bank_ifsc_code, profileResponse.bank_ifsc_code) && this.bank_edit == profileResponse.bank_edit && Intrinsics.areEqual(this.bankdetail_status, profileResponse.bankdetail_status) && this.edit_profile == profileResponse.edit_profile && this.profile_edit_live == profileResponse.profile_edit_live;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.gender.hashCode()) * 31) + this.dob.hashCode()) * 31) + this.religion.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.nationality.hashCode()) * 31) + this.blood_group.hashCode()) * 31) + this.adharno.hashCode()) * 31) + this.register_no.hashCode()) * 31) + this.father_name.hashCode()) * 31) + this.mother_name.hashCode()) * 31) + this.phone_father.hashCode()) * 31) + this.father_occupation.hashCode()) * 31) + this.mother_occupation.hashCode()) * 31) + this.phone_mother.hashCode()) * 31) + this.email.hashCode()) * 31) + this.address1.hashCode()) * 31) + this.address2.hashCode()) * 31) + this.address3.hashCode()) * 31) + this.district.hashCode()) * 31) + this.pin.hashCode()) * 31) + this.state.hashCode()) * 31) + this.phone_home.hashCode()) * 31) + this.bank_name.hashCode()) * 31) + this.bank_branch.hashCode()) * 31) + this.bank_accno.hashCode()) * 31) + this.bank_ifsc_code.hashCode()) * 31;
        boolean z = this.bank_edit;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((hashCode + i) * 31) + this.bankdetail_status.hashCode()) * 31;
        boolean z2 = this.edit_profile;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z3 = this.profile_edit_live;
        return i3 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "ProfileResponse(name=" + this.name + ", gender=" + this.gender + ", dob=" + this.dob + ", religion=" + this.religion + ", admission_no=" + this.admission_no + ", nationality=" + this.nationality + ", blood_group=" + this.blood_group + ", adharno=" + this.adharno + ", register_no=" + this.register_no + ", father_name=" + this.father_name + ", mother_name=" + this.mother_name + ", phone_father=" + this.phone_father + ", father_occupation=" + this.father_occupation + ", mother_occupation=" + this.mother_occupation + ", phone_mother=" + this.phone_mother + ", email=" + this.email + ", address1=" + this.address1 + ", address2=" + this.address2 + ", address3=" + this.address3 + ", district=" + this.district + ", pin=" + this.pin + ", state=" + this.state + ", phone_home=" + this.phone_home + ", bank_name=" + this.bank_name + ", bank_branch=" + this.bank_branch + ", bank_accno=" + this.bank_accno + ", bank_ifsc_code=" + this.bank_ifsc_code + ", bank_edit=" + this.bank_edit + ", bankdetail_status=" + this.bankdetail_status + ", edit_profile=" + this.edit_profile + ", profile_edit_live=" + this.profile_edit_live + ")";
    }

    public ProfileResponse(String name, String gender, String dob, String religion, String admission_no, String nationality, String blood_group, String adharno, String register_no, String father_name, String mother_name, String phone_father, String father_occupation, String mother_occupation, String phone_mother, String email, String address1, String address2, String address3, String district, String pin, String state, String phone_home, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, boolean z, String bankdetail_status, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(dob, "dob");
        Intrinsics.checkNotNullParameter(religion, "religion");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(blood_group, "blood_group");
        Intrinsics.checkNotNullParameter(adharno, "adharno");
        Intrinsics.checkNotNullParameter(register_no, "register_no");
        Intrinsics.checkNotNullParameter(father_name, "father_name");
        Intrinsics.checkNotNullParameter(mother_name, "mother_name");
        Intrinsics.checkNotNullParameter(phone_father, "phone_father");
        Intrinsics.checkNotNullParameter(father_occupation, "father_occupation");
        Intrinsics.checkNotNullParameter(mother_occupation, "mother_occupation");
        Intrinsics.checkNotNullParameter(phone_mother, "phone_mother");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(address1, "address1");
        Intrinsics.checkNotNullParameter(address2, "address2");
        Intrinsics.checkNotNullParameter(address3, "address3");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(pin, "pin");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(phone_home, "phone_home");
        Intrinsics.checkNotNullParameter(bank_name, "bank_name");
        Intrinsics.checkNotNullParameter(bank_branch, "bank_branch");
        Intrinsics.checkNotNullParameter(bank_accno, "bank_accno");
        Intrinsics.checkNotNullParameter(bank_ifsc_code, "bank_ifsc_code");
        Intrinsics.checkNotNullParameter(bankdetail_status, "bankdetail_status");
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.religion = religion;
        this.admission_no = admission_no;
        this.nationality = nationality;
        this.blood_group = blood_group;
        this.adharno = adharno;
        this.register_no = register_no;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.phone_father = phone_father;
        this.father_occupation = father_occupation;
        this.mother_occupation = mother_occupation;
        this.phone_mother = phone_mother;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.district = district;
        this.pin = pin;
        this.state = state;
        this.phone_home = phone_home;
        this.bank_name = bank_name;
        this.bank_branch = bank_branch;
        this.bank_accno = bank_accno;
        this.bank_ifsc_code = bank_ifsc_code;
        this.bank_edit = z;
        this.bankdetail_status = bankdetail_status;
        this.edit_profile = z2;
        this.profile_edit_live = z3;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getDob() {
        return this.dob;
    }

    public final String getReligion() {
        return this.religion;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getBlood_group() {
        return this.blood_group;
    }

    public final String getAdharno() {
        return this.adharno;
    }

    public final String getRegister_no() {
        return this.register_no;
    }

    public final String getFather_name() {
        return this.father_name;
    }

    public final String getMother_name() {
        return this.mother_name;
    }

    public final String getPhone_father() {
        return this.phone_father;
    }

    public final String getFather_occupation() {
        return this.father_occupation;
    }

    public final String getMother_occupation() {
        return this.mother_occupation;
    }

    public final String getPhone_mother() {
        return this.phone_mother;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getAddress1() {
        return this.address1;
    }

    public final String getAddress2() {
        return this.address2;
    }

    public final String getAddress3() {
        return this.address3;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getPin() {
        return this.pin;
    }

    public final String getState() {
        return this.state;
    }

    public final String getPhone_home() {
        return this.phone_home;
    }

    public final String getBank_name() {
        return this.bank_name;
    }

    public final String getBank_branch() {
        return this.bank_branch;
    }

    public final String getBank_accno() {
        return this.bank_accno;
    }

    public final String getBank_ifsc_code() {
        return this.bank_ifsc_code;
    }

    public final boolean getBank_edit() {
        return this.bank_edit;
    }

    public final String getBankdetail_status() {
        return this.bankdetail_status;
    }

    public final boolean getEdit_profile() {
        return this.edit_profile;
    }

    public final boolean getProfile_edit_live() {
        return this.profile_edit_live;
    }
}