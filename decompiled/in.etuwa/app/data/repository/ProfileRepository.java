package in.etuwa.app.data.repository;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.achievements.AchievementsResponse;
import in.etuwa.app.data.model.profileasiet.coursesattended.CoursesAttendedResponse;
import in.etuwa.app.data.model.profileasiet.fundedresearch.FundedResearchResponse;
import in.etuwa.app.data.model.profileasiet.membership.MembershipResponse;
import in.etuwa.app.data.model.profileasiet.mooccourse.MoocCourseResponse;
import in.etuwa.app.data.model.profileasiet.positionheld.PositionHeldResponse;
import in.etuwa.app.data.model.profileasiet.projectwork.ProjectWorkResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationResponse;
import in.etuwa.app.data.model.profileasiet.qualifiedexamination.QualifiedExaminationResponse;
import in.etuwa.app.data.model.profileasiet.scholarships.ScholarshipsResponse;
import in.etuwa.app.data.model.profileasiet.sport.SportResponse;
import in.etuwa.app.data.model.updateprofile.UpdateProfile;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ProfileRepository.kt */
/* loaded from: classes3.dex */
public final class ProfileRepository {
    private final ApiHelper apiHelper;

    public ProfileRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<PublicationResponse> getPublicationUrlApiCall() {
        return this.apiHelper.getPublicationUrlApiCall();
    }

    public final Single<SuccessResponse> addPublicationUrlApiCall(RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addPublicationUrlApiCall(title, journal, conference, index, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updatePublicationUrlApiCall(RequestBody id, RequestBody title, RequestBody journal, RequestBody conference, RequestBody index, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updatePublicationUrlApiCall(id, title, journal, conference, index, yearId, uploadFile);
    }

    public final Single<PublicationDropDownResponse> getProfileDropListUrlApiCall() {
        return this.apiHelper.getProfileDropListUrlApiCall();
    }

    public final Single<SuccessResponse> addPublicationUrlApiCall(String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addPublicationUrlApiCall(title, journal, conference, index, yearId);
    }

    public final Single<SuccessResponse> updatePublicationUrlApiCall(String id, String title, String journal, String conference, String index, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(journal, "journal");
        Intrinsics.checkNotNullParameter(conference, "conference");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updatePublicationUrlApiCall(id, title, journal, conference, index, yearId);
    }

    public final Single<SuccessResponse> deletePublicationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deletePublicationUrlApiCall(id);
    }

    public final Single<FundedResearchResponse> getFundedResearchUrlApiCall() {
        return this.apiHelper.getFundedResearchUrlApiCall();
    }

    public final Single<SuccessResponse> addRResearchUrlApiCall(RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addRResearchUrlApiCall(title, amount, agency, duration, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addRResearchUrlApiCall(String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addRResearchUrlApiCall(title, amount, agency, duration, yearId);
    }

    public final Single<SuccessResponse> updateResearchUrlApiCall(RequestBody id, RequestBody title, RequestBody amount, RequestBody agency, RequestBody duration, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateResearchUrlApiCall(id, title, amount, agency, duration, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateResearchUrlApiCall(String id, String title, String amount, String agency, String duration, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(agency, "agency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateResearchUrlApiCall(id, title, amount, agency, duration, yearId);
    }

    public final Single<SuccessResponse> deleteResearchUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteResearchUrlApiCall(id);
    }

    public final Single<QualifiedExaminationResponse> getQualifiedExaminationUrlApiCall() {
        return this.apiHelper.getQualifiedExaminationUrlApiCall();
    }

    public final Single<SuccessResponse> addQualifiedExaminationUrlApiCall(RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addQualifiedExaminationUrlApiCall(name, score, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addQualifiedExaminationUrlApiCall(String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addQualifiedExaminationUrlApiCall(name, score, yearId);
    }

    public final Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(RequestBody id, RequestBody name, RequestBody score, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateQualifiedExaminationUrlApiCall(id, name, score, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateQualifiedExaminationUrlApiCall(String id, String name, String score, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateQualifiedExaminationUrlApiCall(id, name, score, yearId);
    }

    public final Single<SuccessResponse> deleteQualifiedExaminationUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteQualifiedExaminationUrlApiCall(id);
    }

    public final Single<MoocCourseResponse> getMoocCourseUrlApiCall() {
        return this.apiHelper.getMoocCourseUrlApiCall();
    }

    public final Single<SuccessResponse> addMoocCoursesUrlApiCall(RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiHelper.addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    public final Single<SuccessResponse> addMoocCoursesUrlApiCall(String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiHelper.addMoocCoursesUrlApiCall(title, provider, fromDate, toDate, duration, achievements);
    }

    public final Single<SuccessResponse> updateMoocCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody provider, RequestBody fromDate, RequestBody toDate, RequestBody duration, RequestBody achievements, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiHelper.updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements, uploadFile);
    }

    public final Single<SuccessResponse> updateMoocCoursesUrlApiCall(String id, String title, String provider, String fromDate, String toDate, String duration, String achievements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        return this.apiHelper.updateMoocCoursesUrlApiCall(id, title, provider, fromDate, toDate, duration, achievements);
    }

    public final Single<SuccessResponse> deleteMoocCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteMoocCoursesUrlApiCall(id);
    }

    public final Single<CoursesAttendedResponse> getCoursesAttendedUrlApiCall() {
        return this.apiHelper.getCoursesAttendedUrlApiCall();
    }

    public final Single<SuccessResponse> addCoursesUrlApiCall(RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> addCoursesUrlApiCall(String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.addCoursesUrlApiCall(title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    public final Single<SuccessResponse> updateCoursesUrlApiCall(RequestBody id, RequestBody title, RequestBody organizedBy, RequestBody duration, RequestBody yearId, RequestBody achievements, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updateCoursesUrlApiCall(String id, String title, String organizedBy, String duration, String yearId, String achievements, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(achievements, "achievements");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.updateCoursesUrlApiCall(id, title, organizedBy, duration, yearId, achievements, fromDate, toDate);
    }

    public final Single<SuccessResponse> deleteCoursesUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteCoursesUrlApiCall(id);
    }

    public final Single<ProjectWorkResponse> getProjectWorkUrlApiCall() {
        return this.apiHelper.getProjectWorkUrlApiCall();
    }

    public final Single<SuccessResponse> addProjectWorkUrlApiCall(RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiHelper.addProjectWorkUrlApiCall(type, yearId, details, uploadFile);
    }

    public final Single<SuccessResponse> addProjectWorkUrlApiCall(String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiHelper.addProjectWorkUrlApiCall(type, yearId, details);
    }

    public final Single<SuccessResponse> updateProjectWorkUrlApiCall(RequestBody id, RequestBody type, RequestBody yearId, RequestBody details, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiHelper.updateProjectWorkUrlApiCall(id, type, yearId, details, uploadFile);
    }

    public final Single<SuccessResponse> updateProjectWorkUrlApiCall(String id, String type, String yearId, String details) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(details, "details");
        return this.apiHelper.updateProjectWorkUrlApiCall(id, type, yearId, details);
    }

    public final Single<SuccessResponse> deleteProjectWorkUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteProjectWorkUrlApiCall(id);
    }

    public final Single<ScholarshipsResponse> getScholarshipsUrlApiCall() {
        return this.apiHelper.getScholarshipsUrlApiCall();
    }

    public final Single<SuccessResponse> addScholarshipUrlApiCall(RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addScholarshipUrlApiCall(type, details, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addScholarshipUrlApiCall(String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addScholarshipUrlApiCall(type, details, yearId);
    }

    public final Single<SuccessResponse> updateScholarshipUrlApiCall(RequestBody id, RequestBody type, RequestBody details, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateScholarshipUrlApiCall(id, type, details, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateScholarshipUrlApiCall(String id, String type, String details, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateScholarshipUrlApiCall(id, type, details, yearId);
    }

    public final Single<SuccessResponse> deleteScholarshipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteScholarshipUrlApiCall(id);
    }

    public final Single<SportResponse> getSportUrlApiCall() {
        return this.apiHelper.getSportUrlApiCall();
    }

    public final Single<SuccessResponse> addSportUrlApiCall(RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiHelper.addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    public final Single<SuccessResponse> addSportUrlApiCall(String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiHelper.addSportUrlApiCall(title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    public final Single<SuccessResponse> updateSportUrlApiCall(RequestBody id, RequestBody title, RequestBody eventName, RequestBody organizedBy, RequestBody eventType, RequestBody level, RequestBody date, RequestBody yearId, RequestBody awards, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiHelper.updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards, uploadFile);
    }

    public final Single<SuccessResponse> updateSportUrlApiCall(String id, String title, String eventName, String organizedBy, String eventType, String level, String date, String yearId, String awards) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(organizedBy, "organizedBy");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return this.apiHelper.updateSportUrlApiCall(id, title, eventName, organizedBy, eventType, level, date, yearId, awards);
    }

    public final Single<SuccessResponse> deleteSportUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteSportUrlApiCall(id);
    }

    public final Single<PositionHeldResponse> getPositionHeldUrlApiCall() {
        return this.apiHelper.getPositionHeldUrlApiCall();
    }

    public final Single<SuccessResponse> addPositionHeldUrlApiCall(RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.addPositionHeldUrlApiCall(title, yearId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> addPositionHeldUrlApiCall(String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.addPositionHeldUrlApiCall(title, yearId, fromDate, toDate);
    }

    public final Single<SuccessResponse> updatePositionHeldUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updatePositionHeldUrlApiCall(String id, String title, String yearId, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.updatePositionHeldUrlApiCall(id, title, yearId, fromDate, toDate);
    }

    public final Single<SuccessResponse> deletePositionHeldUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deletePositionHeldUrlApiCall(id);
    }

    public final Single<MembershipResponse> getMembershipUrlApiCall() {
        return this.apiHelper.getMembershipUrlApiCall();
    }

    public final Single<SuccessResponse> addMembershipUrlApiCall(RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiHelper.addMembershipUrlApiCall(title, type, yearId, memberId, description, uploadFile);
    }

    public final Single<SuccessResponse> addMembershipUrlApiCall(String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiHelper.addMembershipUrlApiCall(title, type, yearId, memberId, description);
    }

    public final Single<SuccessResponse> updateMembershipUrlApiCall(RequestBody id, RequestBody title, RequestBody type, RequestBody yearId, RequestBody memberId, RequestBody description, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiHelper.updateMembershipUrlApiCall(id, title, type, yearId, memberId, description, uploadFile);
    }

    public final Single<SuccessResponse> updateMembershipUrlApiCall(String id, String title, String type, String yearId, String memberId, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(description, "description");
        return this.apiHelper.updateMembershipUrlApiCall(id, title, type, yearId, memberId, description);
    }

    public final Single<SuccessResponse> deleteMembershipUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteMembershipUrlApiCall(id);
    }

    public final Single<AchievementsResponse> getAchievementsUrlApiCall() {
        return this.apiHelper.getAchievementsUrlApiCall();
    }

    public final Single<SuccessResponse> addAchievementUrlApiCall(RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addAchievementUrlApiCall(title, yearId, uploadFile);
    }

    public final Single<SuccessResponse> addAchievementUrlApiCall(String title, String yearId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.addAchievementUrlApiCall(title, yearId);
    }

    public final Single<SuccessResponse> updateAchievementUrlApiCall(RequestBody id, RequestBody title, RequestBody yearId, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateAchievementUrlApiCall(id, title, yearId, uploadFile);
    }

    public final Single<SuccessResponse> updateAchievementUrlApiCall(String id, String title, String yearId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        return this.apiHelper.updateAchievementUrlApiCall(id, title, yearId);
    }

    public final Single<SuccessResponse> deleteAchievementUrlApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteAchievementUrlApiCall(id);
    }

    public final Single<UpdateProfile> getUpdateProfileApiCall() {
        return this.apiHelper.getUpdateProfileApiCall();
    }
}