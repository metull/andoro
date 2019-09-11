package CheckProfile.GeneralData;

import static CheckProfile.GeneralData.Data.*;

public class SetterAndGetter {

    // Параметры анкеты для отправки

    public static String serial_number_passport = randomSerialNumberPassport(4) + " " + randomSerialNumberPassport(6);
    public static String last_name = randomLastName();
    public static String first_name = randomFirstName();
    public static String second_name = randomSecondName();
    public static String sex = "1Ig8y7SX";
    public static String birthday = "01.02.1975";
    public static String monthly_income = "130000";
    public static String email = "email@email.ru";
    public static String date_issue = "01.02.2010";
    public static String issued_passport = "МЕЖРАЙОННЫМ ОТДЕЛОМ УФМС РОССИИ ПО КАЛУЖСКОЙ ОБЛАСТИ В Г. КИРОВЕ";
    public static String birthplace = "Москва";
    public static String subdivision_code = "400-032";
    public static String position_type = "LdclPMjJ";
    public static String social_status = "Kwt5ypR2";
    public static String children = "0";
    public static String costs = "12000";
    public static String mother_last_name = "Смирнова";
    public static String company_name = "ООО Русь Матушка";
    public static String work_in_last_place_years = "5";
    public static String phone_work = "(498) 465-13-25";
    public static String marital_status = "ltS0HkZ6";
    public static String education = "AJZRN1S4";
    public static String last_name_contact = "Вадимов";
    public static String name_contact = "Николай";
    public static String second_name_contact = "Антонович";
    public static String phone_contact = "(986) 153-5463";
    public static String work_in_last_place_months = "5";
    public static String date_reg = "01.02.2010";
    public static String property_type_home = "OBwD06es";
    public static String real_estate = "roommts";
    public static String customer_estimate = "lx6yuJzL";
    public static String spouse_startdate = "01.02.2010";
    public static String business_type = "rJ53DhFk";
    public static String phone_home = "(986) 435-8657";
    public static String price = "52000";
    protected static String product_name = "Товар Оки-Доки";
    public static String outlet_store = "103421177";
    public static String spouse_last_name = "Смирнова";
    public static String spouse_first_name = "Ирина";
    public static String spouse_second_name = "Борисовна";
    public static String spouse_birthday = "01.02.1975";
    public static String relation_degree = "Y1mQPKVz";
    public static String last_name_contact_add = "Изотов";
    public static String name_contact_add = "Игорь";
    public static String second_name_contact_add = "Павлович";
    public static String phone_contact_add = "(983) 422-8617";
    public static String spouse_work_position = "2000857";
    public static String spouse_company_name = "ООО Аврал Астер";
    public static String country_of_birth = "jExN2Qe";
    public static int family_monthly_income = 130000;
    public static int utilities_monthly_payments = 13000;
    public static String loans_monthly_payments = "0";
    public static String compulsory_monthly_payments = "0";
    public static String dependents = "0";
    public static String employees = "nWLiVkM4";
    public static String leader_name = "Вадимов Николай Петрович";
    public static String max_monthly_payment = "12000";
    public static String joint_residence = "ohSvX2j1";

// Параметры для запроса в БД

    private static String table_b_iblock_element_prop_s10 = "b_iblock_element_prop_s10";
    private static String table_dc_customer_profile = "dc_customer_profile";
    static String table_dc_order = "dc_order";

    private static String customerProfileIdBD = "customer_profile_id";
    private static String orderNumber = "order_number";

    private static String lastNameBD = "PROPERTY_32";
    private static String firstNameBD = "PROPERTY_33";
    private static String secondNameBD = "PROPERTY_34";
    private static String birthdayBD = "PROPERTY_35";
    private static String sexBD = "PROPERTY_36";
    private static String emailBD = "PROPERTY_45";
    private static String dateIssuedBD = "PROPERTY_173";
    private static String monthlyIncomeBD = "PROPERTY_77";
    private static String serialPassportBD = "PROPERTY_112";
    private static String numberPassportBD = "PROPERTY_172";
    private static String iblockElementIdBD = "IBLOCK_ELEMENT_ID";
    private static String subdivisionCodeBD = "PROPERTY_175";
    private static String issuedPassportBD = "PROPERTY_176";
    private static String birthplaceBD = "PROPERTY_177";
    private static String dateRegBD = "PROPERTY_92";
    private static String propertyTypeHomeBD = "PROPERTY_105";
    private static String maritalStatusBD = "PROPERTY_37";
    private static String childrenBD = "PROPERTY_42";
    private static String educationBD = "PROPERTY_44";
    private static String costsBD = "PROPERTY_79";
    private static String motherLastNameBD = "PROPERTY_43";
    private static String companyNameBD = "PROPERTY_50";
    private static String positionTypeBD = "PROPERTY_53";
    private static String phoneWorkBD = "PROPERTY_60";
    private static String relationDegreeBD = "PROPERTY_378";
    private static String lastNameContactBD = "PROPERTY_46";
    private static String nameContactBD = "PROPERTY_47";
    private static String secondNameContactBD = "PROPERTY_48";
    private static String phoneContactBD = "PROPERTY_49";
    private static String socialStatusBD = "PROPERTY_58";
    private static String businessTypeBD = "PROPERTY_52";
    private static String workInLastPlaceYearsBD = "PROPERTY_59";
    private static String realEstateBD = "PROPERTY_108";

    public static String getJoint_residence() {
        return joint_residence;
    }

    public static void setJoint_residence(String joint_residence) {
        SetterAndGetter.joint_residence = joint_residence;
    }

    public static String getMax_monthly_payment() {
        return max_monthly_payment;
    }

    public static void setMax_monthly_payment(String max_monthly_payment) {
        SetterAndGetter.max_monthly_payment = max_monthly_payment;
    }

    public static String getLeader_name() {
        return leader_name;
    }

    public static void setLeader_name(String leader_name) {
        SetterAndGetter.leader_name = leader_name;
    }

    public static String getEmployees() {
        return employees;
    }

    public static void setEmployees(String employees) {
        SetterAndGetter.employees = employees;
    }

    public static int getFamily_monthly_income() {
        return family_monthly_income;
    }

    public static void setFamily_monthly_income(int family_monthly_income) {
        SetterAndGetter.family_monthly_income = family_monthly_income;
    }

    public static int getUtilities_monthly_payments() {
        return utilities_monthly_payments;
    }

    public static void setUtilities_monthly_payments(int utilities_monthly_payments) {
        SetterAndGetter.utilities_monthly_payments = utilities_monthly_payments;
    }

    public static String getLoans_monthly_payments() {
        return loans_monthly_payments;
    }

    public static void setLoans_monthly_payments(String loans_monthly_payments) {
        SetterAndGetter.loans_monthly_payments = loans_monthly_payments;
    }

    public static String getCompulsory_monthly_payments() {
        return compulsory_monthly_payments;
    }

    public static void setCompulsory_monthly_payments(String compulsory_monthly_payments) {
        SetterAndGetter.compulsory_monthly_payments = compulsory_monthly_payments;
    }

    public static String getDependents() {
        return dependents;
    }

    public static void setDependents(String dependents) {
        SetterAndGetter.dependents = dependents;
    }

    public static String getCountry_of_birth() {
        return country_of_birth;
    }

    public static void setCountry_of_birth(String country_of_birth) {
        SetterAndGetter.country_of_birth = country_of_birth;
    }

    public static String getSpouse_work_position() {
        return spouse_work_position;
    }

    public static void setSpouse_work_position(String spouse_work_position) {
        SetterAndGetter.spouse_work_position = spouse_work_position;
    }

    public static String getSpouse_company_name() {
        return spouse_company_name;
    }

    public static void setSpouse_company_name(String spouse_company_name) {
        SetterAndGetter.spouse_company_name = spouse_company_name;
    }

    public static String getCustomer_estimate() {
        return customer_estimate;
    }

    public static void setCustomer_estimate(String customer_estimate) {
        SetterAndGetter.customer_estimate = customer_estimate;
    }

    public static String getOutlet_store() {
        return outlet_store;
    }

    public static void setOutlet_store(String outlet_store) {
        SetterAndGetter.outlet_store = outlet_store;
    }

    protected static String getProduct_name() {
        return product_name;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        SetterAndGetter.price = price;
    }

    public static String getTable_dc_customer_profile() {
        return table_dc_customer_profile;
    }

    public static String getRealEstateBD() {
        return realEstateBD;
    }

    public static String getBusiness_type() {
        return business_type;
    }

    public static void setBusiness_type(String business_type) {
        SetterAndGetter.business_type = business_type;
    }

    public static String getSocialStatusBD() {
        return socialStatusBD;
    }

    public static String getBusinessTypeBD() {
        return businessTypeBD;
    }

    public static String getWorkInLastPlaceYearsBD() {
        return workInLastPlaceYearsBD;
    }

    public static String getReal_estate() {
        return real_estate;
    }

    public static void setReal_estate(String real_estate) {
        SetterAndGetter.real_estate = real_estate;
    }

    public static String getRelation_degree() {
        return relation_degree;
    }

    public static void setRelation_degree(String relation_degree) {
        SetterAndGetter.relation_degree = relation_degree;
    }

    public static String getSocial_status() {
        return social_status;
    }

    public static void setSocial_status(String social_status) {
        SetterAndGetter.social_status = social_status;
    }

    public static String getPosition_type() {
        return position_type;
    }

    public static void setPosition_type(String position_type) {
        SetterAndGetter.position_type = position_type;
    }

    public static String getEducation() {
        return education;
    }

    public static void setEducation(String education) {
        SetterAndGetter.education = education;
    }

    public static String getMarital_status() {
        return marital_status;
    }

    public static void setMarital_status(String marital_status) {
        SetterAndGetter.marital_status = marital_status;
    }

    public static String getPropertyTypeHomeBD() {
        return propertyTypeHomeBD;
    }

    public static String getMaritalStatusBD() {
        return maritalStatusBD;
    }

    public static String getChildrenBD() {
        return childrenBD;
    }

    public static String getEducationBD() {
        return educationBD;
    }

    public static String getCostsBD() {
        return costsBD;
    }

    public static String getMotherLastNameBD() {
        return motherLastNameBD;
    }

    public static String getCompanyNameBD() {
        return companyNameBD;
    }

    public static String getPositionTypeBD() {
        return positionTypeBD;
    }

    public static String getPhoneWorkBD() {
        return phoneWorkBD;
    }

    public static String getRelationDegreeBD() {
        return relationDegreeBD;
    }

    public static String getLastNameContactBD() {
        return lastNameContactBD;
    }

    public static String getNameContactBD() {
        return nameContactBD;
    }

    public static String getPhoneContactBD() {
        return phoneContactBD;
    }

    public static String getSubdivisionCodeBD() {
        return subdivisionCodeBD;
    }

    public static String getIssuedPassportBD() {
        return issuedPassportBD;
    }

    public static String getBirthplaceBD() {
        return birthplaceBD;
    }

    public static String getDateRegBD() {
        return dateRegBD;
    }

    public static String getDateIssuedBD() {
        return dateIssuedBD;
    }

    public static String getSerialPassportBD() {
        return serialPassportBD;
    }

    public static String getNumberPassportBD() {
        return numberPassportBD;
    }

    public static String getMonthlyIncomeBD() {
        return monthlyIncomeBD;
    }

    public static String getEmailBD() {
        return emailBD;
    }

    public static String getSexBD() {
        return sexBD;
    }

    public static String getBirthdayBD() {
        return birthdayBD;
    }

    static String getOrderNumber() {
        return orderNumber;
    }

    public static String getIblockElementIdBD() {
        return iblockElementIdBD;
    }

    static String getCustomerProfileIdBD() {
        return customerProfileIdBD;
    }

    public static String getFirstNameBD() {
        return firstNameBD;
    }

    public static String getSecondNameBD() {
        return secondNameBD;
    }

    public static String getTable_b_iblock_element_prop_s10() {
        return table_b_iblock_element_prop_s10;
    }

    public static String getLastNameBD() {
        return lastNameBD;
    }

    public static String getPhone_home() {
        return phone_home;
    }

    public static void setPhone_home(String phone_home) {
        SetterAndGetter.phone_home = phone_home;
    }

    public static String getSpouse_startdate() {
        return spouse_startdate;
    }

    public static String getSpouse_last_name() {
        return spouse_last_name;
    }

    public static String getSpouse_first_name() {
        return spouse_first_name;
    }

    public static String getSpouse_second_name() {
        return spouse_second_name;
    }

    public static String getSpouse_birthday() {
        return spouse_birthday;
    }

    public static String getLast_name_contact_add() {
        return last_name_contact_add;
    }


    public static String getName_contact_add() {
        return name_contact_add;
    }

    public static String getSecond_name_contact_add() {
        return second_name_contact_add;
    }

    public static String getPhone_contact_add() {
        return phone_contact_add;
    }

    public static String getDate_reg() {
        return date_reg;
    }

    public static String getChildren() {
        return children;
    }

    public static String getCosts() {
        return costs;
    }

    public static String getMother_last_name() {
        return mother_last_name;
    }

    public static String getCompany_name() {
        return company_name;
    }

    public static String getWork_in_last_place_years() {
        return work_in_last_place_years;
    }

    public static String getWork_in_last_place_months() {
        return work_in_last_place_months;
    }

    public static String getPhone_work() {
        return phone_work;
    }

    public static String getLast_name_contact() {
        return last_name_contact;
    }

    public static String getName_contact() {
        return name_contact;
    }

    public static String getSecond_name_contact() {
        return second_name_contact;
    }

    public static String getPhone_contact() {
        return phone_contact;
    }

    public static String getSubdivision_code() {
        return subdivision_code;
    }

    public static String getBirthplace() {
        return birthplace;
    }

    public static String getIssued_passport() {
        return issued_passport;
    }

    public static String getSerial_number_passport() {
        return serial_number_passport;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static String getSecond_name() {
        return second_name;
    }

    public static String getSex() {
        return sex;
    }

    public static String getBirthday() {
        return birthday;
    }

    public static String getMonthly_income() {
        return monthly_income;
    }

    public static String getEmail() {
        return email;
    }

    public static String getDate_issue() {
        return date_issue;
    }

    public static String getProperty_type_home() {
        return property_type_home;
    }

    public static void setProperty_type_home(String property_type_home) {
        SetterAndGetter.property_type_home = property_type_home;
    }

}
