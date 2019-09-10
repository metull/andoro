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
    public static String product_name = "Товар Оки-Доки";
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

    public static String table_b_iblock_element_prop_s10 = "b_iblock_element_prop_s10";
    public static String table_dc_customer_profile = "dc_customer_profile";
    public static String table_dc_order = "dc_order";

    public static String customerProfileIdBD = "customer_profile_id";
    public static String orderNumber = "order_number";

    public static String lastNameBD = "PROPERTY_32";
    public static String firstNameBD = "PROPERTY_33";
    public static String secondNameBD = "PROPERTY_34";
    public static String birthdayBD = "PROPERTY_35";
    public static String sexBD = "PROPERTY_36";
    public static String emailBD = "PROPERTY_45";
    public static String dateIssuedBD = "PROPERTY_173";
    public static String monthlyIncomeBD = "PROPERTY_77";
    public static String serialPassportBD = "PROPERTY_112";
    public static String numberPassportBD = "PROPERTY_172";
    public static String iblockElementIdBD = "IBLOCK_ELEMENT_ID";
    public static String subdivisionCodeBD = "PROPERTY_175";
    public static String issuedPassportBD = "PROPERTY_176";
    public static String birthplaceBD = "PROPERTY_177";
    public static String dateRegBD = "PROPERTY_92";
    public static String propertyTypeHomeBD = "PROPERTY_105";
    public static String maritalStatusBD = "PROPERTY_37";
    public static String childrenBD = "PROPERTY_42";
    public static String educationBD = "PROPERTY_44";
    public static String costsBD = "PROPERTY_79";
    public static String motherLastNameBD = "PROPERTY_43";
    public static String companyNameBD = "PROPERTY_50";
    public static String positionTypeBD = "PROPERTY_53";
    public static String phoneWorkBD = "PROPERTY_60";
    public static String relationDegreeBD = "PROPERTY_378";
    public static String lastNameContactBD = "PROPERTY_46";
    public static String nameContactBD = "PROPERTY_47";
    public static String secondNameContactBD = "PROPERTY_48";
    public static String phoneContactBD = "PROPERTY_49";
    public static String socialStatusBD = "PROPERTY_58";
    public static String businessTypeBD = "PROPERTY_52";
    public static String workInLastPlaceYearsBD = "PROPERTY_59";
    public static String realEstateBD = "PROPERTY_108";



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

    public static String getProduct_name() {
        return product_name;
    }

    public static void setProduct_name(String product_name) {
        SetterAndGetter.product_name = product_name;
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

    public static void setTable_dc_customer_profile(String table_dc_customer_profile) {
        SetterAndGetter.table_dc_customer_profile = table_dc_customer_profile;
    }

    public static String getRealEstateBD() {
        return realEstateBD;
    }

    public static void setRealEstateBD(String realEstateBD) {
        SetterAndGetter.realEstateBD = realEstateBD;
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

    public static void setSocialStatusBD(String socialStatusBD) {
        SetterAndGetter.socialStatusBD = socialStatusBD;
    }

    public static String getBusinessTypeBD() {
        return businessTypeBD;
    }

    public static String getWorkInLastPlaceYearsBD() {
        return workInLastPlaceYearsBD;
    }

    public static void setWorkInLastPlaceYearsBD(String workInLastPlaceYearsBD) {
        SetterAndGetter.workInLastPlaceYearsBD = workInLastPlaceYearsBD;
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

    public static void setPropertyTypeHomeBD(String propertyTypeHomeBD) {
        SetterAndGetter.propertyTypeHomeBD = propertyTypeHomeBD;
    }

    public static String getMaritalStatusBD() {
        return maritalStatusBD;
    }

    public static void setMaritalStatusBD(String maritalStatusBD) {
        SetterAndGetter.maritalStatusBD = maritalStatusBD;
    }

    public static String getChildrenBD() {
        return childrenBD;
    }

    public static void setChildrenBD(String childrenBD) {
        SetterAndGetter.childrenBD = childrenBD;
    }

    public static String getEducationBD() {
        return educationBD;
    }

    public static void setEducationBD(String educationBD) {
        SetterAndGetter.educationBD = educationBD;
    }

    public static String getCostsBD() {
        return costsBD;
    }

    public static void setCostsBD(String costsBD) {
        SetterAndGetter.costsBD = costsBD;
    }

    public static String getMotherLastNameBD() {
        return motherLastNameBD;
    }

    public static void setMotherLastNameBD(String motherLastNameBD) {
        SetterAndGetter.motherLastNameBD = motherLastNameBD;
    }

    public static String getCompanyNameBD() {
        return companyNameBD;
    }

    public static void setCompanyNameBD(String companyNameBD) {
        SetterAndGetter.companyNameBD = companyNameBD;
    }

    public static String getPositionTypeBD() {
        return positionTypeBD;
    }

    public static void setPositionTypeBD(String positionTypeBD) {
        SetterAndGetter.positionTypeBD = positionTypeBD;
    }

    public static String getPhoneWorkBD() {
        return phoneWorkBD;
    }

    public static void setPhoneWorkBD(String phoneWorkBD) {
        SetterAndGetter.phoneWorkBD = phoneWorkBD;
    }

    public static String getRelationDegreeBD() {
        return relationDegreeBD;
    }

    public static void setRelationDegreeBD(String relationDegreeBD) {
        SetterAndGetter.relationDegreeBD = relationDegreeBD;
    }

    public static String getLastNameContactBD() {
        return lastNameContactBD;
    }

    public static void setLastNameContactBD(String lastNameContactBD) {
        SetterAndGetter.lastNameContactBD = lastNameContactBD;
    }

    public static String getNameContactBD() {
        return nameContactBD;
    }

    public static void setNameContactBD(String nameContactBD) {
        SetterAndGetter.nameContactBD = nameContactBD;
    }

    public static String getSecondNameContactBD() {
        return secondNameContactBD;
    }

    public static void setSecondNameContactBD(String secondNameContactBD) {
        SetterAndGetter.secondNameContactBD = secondNameContactBD;
    }

    public static String getPhoneContactBD() {
        return phoneContactBD;
    }

    public static void setPhoneContactBD(String phoneContactBD) {
        SetterAndGetter.phoneContactBD = phoneContactBD;
    }


    public static String getSubdivisionCodeBD() {
        return subdivisionCodeBD;
    }

    public static void setSubdivisionCodeBD(String subdivisionCodeBD) {
        SetterAndGetter.subdivisionCodeBD = subdivisionCodeBD;
    }

    public static String getIssuedPassportBD() {
        return issuedPassportBD;
    }

    public static void setIssuedPassportBD(String issuedPassportBD) {
        SetterAndGetter.issuedPassportBD = issuedPassportBD;
    }

    public static String getBirthplaceBD() {
        return birthplaceBD;
    }

    public static void setBirthplaceBD(String birthplaceBD) {
        SetterAndGetter.birthplaceBD = birthplaceBD;
    }

    public static String getDateRegBD() {
        return dateRegBD;
    }

    public static void setDateRegBD(String dateRegBD) {
        SetterAndGetter.dateRegBD = dateRegBD;
    }

    public static String getDateIssuedBD() {
        return dateIssuedBD;
    }

    public static void setDateIssuedBD(String dateIssuedBD) {
        SetterAndGetter.dateIssuedBD = dateIssuedBD;
    }

    public static String getSerialPassportBD() {
        return serialPassportBD;
    }

    public static void setSerialPassportBD(String serialPassportBD) {
        SetterAndGetter.serialPassportBD = serialPassportBD;
    }

    public static String getNumberPassportBD() {
        return numberPassportBD;
    }

    public static void setNumberPassportBD(String numberPassportBD) {
        SetterAndGetter.numberPassportBD = numberPassportBD;
    }

    public static String getMonthlyIncomeBD() {
        return monthlyIncomeBD;
    }

    public static void setMonthlyIncomeBD(String monthlyIncomeBD) {
        SetterAndGetter.monthlyIncomeBD = monthlyIncomeBD;
    }

    public static String getEmailBD() {
        return emailBD;
    }

    public static void setEmailBD(String emailBD) {
        SetterAndGetter.emailBD = emailBD;
    }

    public static String getSexBD() {
        return sexBD;
    }

    public static void setSexBD(String sexBD) {
        SetterAndGetter.sexBD = sexBD;
    }

    public static String getBirthdayBD() {
        return birthdayBD;
    }

    public static void setBirthdayBD(String birthdayBD) {
        SetterAndGetter.birthdayBD = birthdayBD;
    }

    public static String getOrderNumber() {
        return orderNumber;
    }

    public static void setOrderNumber(String orderNumber) {
        SetterAndGetter.orderNumber = orderNumber;
    }

    public static String getIblockElementIdBD() {
        return iblockElementIdBD;
    }

    public static void setIblockElementIdBD(String iblockElementIdBD) {
        SetterAndGetter.iblockElementIdBD = iblockElementIdBD;
    }

    public static String getTable_dc_order() {
        return table_dc_order;
    }

    public static void setTable_dc_order(String table_dc_order) {
        SetterAndGetter.table_dc_order = table_dc_order;
    }

    public static String getCustomerProfileIdBD() {
        return customerProfileIdBD;
    }

    public static void setCustomerProfileIdBD(String customerProfileIdBD) {
        SetterAndGetter.customerProfileIdBD = customerProfileIdBD;
    }

    public static String getFirstNameBD() {
        return firstNameBD;
    }

    public static void setFirstNameBD(String firstNameBD) {
        SetterAndGetter.firstNameBD = firstNameBD;
    }

    public static String getSecondNameBD() {
        return secondNameBD;
    }

    public static void setSecondNameBD(String secondNameBD) {
        SetterAndGetter.secondNameBD = secondNameBD;
    }

    public static String getTable_b_iblock_element_prop_s10() {
        return table_b_iblock_element_prop_s10;
    }

    public static void setTable_b_iblock_element_prop_s10(String table_b_iblock_element_prop_s10) {
        SetterAndGetter.table_b_iblock_element_prop_s10 = table_b_iblock_element_prop_s10;
    }

    public static String getLastNameBD() {
        return lastNameBD;
    }

    public static void setLastNameBD(String firstName) {
        SetterAndGetter.lastNameBD = firstName;
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

    public static void setSpouse_startdate(String spouse_startdate) {
        spouse_startdate = spouse_startdate;
    }

    public static String getSpouse_last_name() {
        return spouse_last_name;
    }

    public static void setSpouse_last_name(String spouse_last_name) {
        spouse_last_name = spouse_last_name;
    }

    public static String getSpouse_first_name() {
        return spouse_first_name;
    }

    public static void setSpouse_first_name(String spouse_first_name) {
        spouse_first_name = spouse_first_name;
    }

    public static String getSpouse_second_name() {
        return spouse_second_name;
    }

    public static void setSpouse_second_name(String spouse_second_name) {
        spouse_second_name = spouse_second_name;
    }

    public static String getSpouse_birthday() {
        return spouse_birthday;
    }

    public static void setSpouse_birthday(String spouse_birthday) {
        spouse_birthday = spouse_birthday;
    }

    public static void setRelation_degree_add(String relation_degree_add) {
        relation_degree_add = relation_degree_add;
    }

    public static String getLast_name_contact_add() {
        return last_name_contact_add;
    }

    public static void setLast_name_contact_add(String last_name_contact_add) {
        last_name_contact_add = last_name_contact_add;
    }

    public static String getName_contact_add() {
        return name_contact_add;
    }

    public static void setName_contact_add(String name_contact_add) {
        name_contact_add = name_contact_add;
    }

    public static String getSecond_name_contact_add() {
        return second_name_contact_add;
    }

    public static void setSecond_name_contact_add(String second_name_contact_add) {
        second_name_contact_add = second_name_contact_add;
    }

    public static String getPhone_contact_add() {
        return phone_contact_add;
    }

    public static void setPhone_contact_add(String phone_contact_add) {
        phone_contact_add = phone_contact_add;
    }

    public static String getDate_reg() {
        return date_reg;
    }

    public static void setDate_reg(String date_reg) {
        date_reg = date_reg;
    }

    public static String getChildren() {
        return children;
    }

    public static void setChildren(String children) {
        children = children;
    }

    public static String getCosts() {
        return costs;
    }

    public static void setCosts(String costs) {
        costs = costs;
    }

    public static String getMother_last_name() {
        return mother_last_name;
    }

    public static void setMother_last_name(String mother_last_name) {
        mother_last_name = mother_last_name;
    }

    public static String getCompany_name() {
        return company_name;
    }

    public static void setCompany_name(String company_name) {
        company_name = company_name;
    }

    public static String getWork_in_last_place_years() {
        return work_in_last_place_years;
    }

    public static void setWork_in_last_place_years(String work_in_last_place_years) {
        work_in_last_place_years = work_in_last_place_years;
    }

    public static String getWork_in_last_place_months() {
        return work_in_last_place_months;
    }

    public static void setWork_in_last_place_months(String work_in_last_place_months) {
        work_in_last_place_months = work_in_last_place_months;
    }

    public static String getPhone_work() {
        return phone_work;
    }

    public static void setPhone_work(String phone_work) {
        phone_work = phone_work;
    }

    public static String getLast_name_contact() {
        return last_name_contact;
    }

    public static void setLast_name_contact(String last_name_contact) {
        last_name_contact = last_name_contact;
    }

    public static String getName_contact() {
        return name_contact;
    }

    public static void setName_contact(String name_contact) {
        name_contact = name_contact;
    }

    public static String getSecond_name_contact() {
        return second_name_contact;
    }

    public static void setSecond_name_contact(String second_name_contact) {
        second_name_contact = second_name_contact;
    }

    public static String getPhone_contact() {
        return phone_contact;
    }

    public static void setPhone_contact(String phone_contact) {
        phone_contact = phone_contact;
    }

    public static String getSubdivision_code() {
        return subdivision_code;
    }

    public static void setSubdivision_code(String subdivision_code) {
        subdivision_code = subdivision_code;
    }

    public static String getBirthplace() {
        return birthplace;
    }

    public static void setBirthplace(String birthplace) {
        birthplace = birthplace;
    }

    public static String getIssued_passport() {
        return issued_passport;
    }

    public static void setIssued_passport(String issued_passport) {
        issued_passport = issued_passport;
    }

    public static String getSerial_number_passport() {
        return serial_number_passport;
    }

    public static void main(String[] args) {
        getSerial_number_passport();
    }

    public static void getSerial_number_passport(int serial_number_passport) {
        serial_number_passport = serial_number_passport;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static void setLast_name(String last_name) {
        last_name = last_name;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static void setFirst_name(String first_name) {
        first_name = first_name;
    }

    public static String getSecond_name() {
        return second_name;
    }

    public static void setSecond_name(String second_name) {
        second_name = second_name;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        sex = sex;
    }

    public static String getBirthday() {
        return birthday;
    }

    public static void setBirthday(String birthday) {
        birthday = birthday;
    }

    public static String getMonthly_income() {
        return monthly_income;
    }

    public static void setMonthly_income(String monthly_income) {
        monthly_income = monthly_income;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        email = email;
    }

    public static String getDate_issue() {
        return date_issue;
    }

    public static void setDate_issue(String date_issue) {
        date_issue = date_issue;
    }

    public static String getProperty_type_home() {
        return property_type_home;
    }

    public static void setProperty_type_home(String property_type_home) {
        SetterAndGetter.property_type_home = property_type_home;
    }

}
