export interface DownloadModel {
    id?: number;
    position?: number;
}
export interface PushModel {
    id?: number;
    msg: string;
    time: string;
    title: string;
}
export interface SemRegError {
    semester_id: Array<string>;
}
export interface SemRegSuccessResponse {
    error: string;
    login?: boolean;
    message: string;
    success?: boolean;
}
export interface Semester {
    id: string;
    name: string;
}
export interface SuccessResponse {
    error: string;
    login?: boolean;
    message: string;
    success?: boolean;
}
export namespace video {
    export interface VideoResponse {
        error: string;
        login?: boolean;
        videos: Array<Videos>;
    }
    export interface Videos {
        date: string;
        description: string;
        id: string;
        sem: string;
        subject: string;
        title: string;
        type?: number;
        url: string;
    }
}
export namespace updateprofile {
    export interface UpdateProfile {
        login?: boolean;
        success?: boolean;
        url: string;
    }
}
export namespace university {
    export interface UniversityResult {
        branch: string;
        code: string;
        credit: string;
        grade: string;
        month_year: string;
        name: string;
        pass_status: string;
        program: string;
        reg_no: string;
        semester: string;
    }
    export interface UniversityResultResponse {
        branch: string;
        earned_credit: string;
        error: string;
        program: string;
        reg_no: string;
        result: Array<UniversityResult>;
        semester: string;
        sgpa: string;
    }
}
export namespace tutorial {
    export interface Tutorial {
        can_download?: boolean;
        can_submit?: boolean;
        details: string;
        finish_time: string;
        id: string;
        issued_on: string;
        last_date: string;
        semester: string;
        status: string;
        subject: string;
        title: string;
        type: string;
        uploaded_file: string;
        url: string;
    }
    export interface TutorialResponse {
        login?: boolean;
        message: string;
        tutorials: Array<Tutorial>;
    }
}
export namespace transportpalai {
    export interface BusPass {
        admission_no: string;
        batch: string;
        boarding: string;
        category: string;
        duration: string;
        error: string;
        full_name: string;
        gender: string;
        login?: boolean;
        pass_code: string;
        photo_url: string;
        program: string;
        qr_code: string;
        route: string;
        semester: string;
        url: string;
        validity: string;
    }
    export namespace registration {
        export interface Boardings {
            id?: number;
            name: string;
        }
        export interface History {
            id: string;
            name: string;
            reg_date: string;
            start_date: string;
            status: string;
            year: string;
        }
        export interface RegisterSucessResponse {
            error: string;
            login?: boolean;
            message: string;
            success?: boolean;
        }
        export interface RegisterViewResponse {
            admission_no: string;
            batch: string;
            boardings: Array<Boardings>;
            full_name: string;
            history: Array<History>;
            login?: boolean;
        }
    }
}
export namespace transport {
    export interface TransportFeeResponse {
        boarding_point: string;
        error: string;
        installments: Array<TransportInstallments>;
        login?: boolean;
        student_id: string;
        years: Array<transportpalai.registration.Boardings>;
    }
    export interface TransportHistory {
        adjustment: string;
        amount: string;
        balance?: number;
        paid: string;
        particular: string;
    }
    export interface TransportHistoryResponse {
        history: Array<TransportHistory>;
        login?: boolean;
    }
    export interface TransportInstallments {
        adjustment: string;
        amount: string;
        balance?: number;
        fullpaid?: boolean;
        head_id: string;
        installment_id: string;
        paid: string;
        particular: string;
        totalAmount?: number;
    }
    export interface TransportPayUrl {
        fine: string;
        total: string;
        url: string;
    }
    export interface TransportYear {
        id?: number;
        name: string;
    }
}
export namespace timetable {
    export interface TimeTable {
        subject?: string;
        timeperiod?: string;
        type?: string;
    }
    export interface TimeTablePeriod {
        day: string;
        sub: Array<TimeTable>;
    }
    export interface TimetableResponse {
        error: string;
        login?: boolean;
        timetable: Array<TimeTablePeriod>;
    }
    export namespace special {
        export interface SpecialResponse {
            date: string;
            period: string;
            subject: string;
            teacher: string;
        }
    }
    export namespace change {
        export interface ChangeTimeTableResponse {
            date: string;
            inplace: string;
            period: string;
            teacher: string;
        }
    }
}
export namespace survey {
    export interface GenSurveyQuestionRequest {
        survey_id?: string;
    }
    export interface SubmitResponse {
        response: string;
        status: string;
    }
    export interface Survey {
        btn_status: string;
        complete?: boolean;
        last_date: string;
        name: string;
        session: string;
        survey_id: string;
        type: string;
    }
    export interface SurveyAnswer {
        answer: string;
        qid: string;
        type: string;
    }
    export interface SurveyQuestion {
        check?: Array<string>;
        id?: Array<string>;
        option?: Array<string>;
        qid?: string;
        question?: string;
        required?: string;
        type?: string;
    }
    export interface SurveyRequest {
        subject_id?: string;
        survey_id?: string;
        teacher_id?: string;
    }
    export interface TeacherList {
        btn_msg: string;
        image: string;
        semester: string;
        status: string;
        subject: string;
        subject_id: string;
        teacher: string;
        teacher_id: string;
    }
    export namespace posurvey {
        export interface POSurvey {
            btn: string;
            end_date: string;
            id: string;
            session: string;
            start_date: string;
            status: string;
            survey: string;
        }
        export interface POSurveyResponse {
            posurvey: Array<POSurvey>;
        }
        export interface PoOptions {
            option_id: string;
            option_name: string;
        }
        export interface PoQuestions {
            answer: string;
            options: Array<PoOptions>;
            q_id: string;
            q_name: string;
            required?: boolean;
        }
        export interface PoQuestionsResponse {
            period: string;
            questions: Array<PoQuestions>;
            survey: string;
            type: string;
        }
    }
    export namespace graduateexit {
        export interface DoGraduateSurveyQuestions {
            answer_id: string;
            option_id: string;
            options: Array<GEOptions>;
            q_id: string;
            question: string;
            required?: boolean;
            section: string;
            type: string;
        }
        export interface DoGraduateSurveyResponse {
            gequestions: Array<DoGraduateSurveyQuestions>;
        }
        export interface GEOptions {
            option: string;
            option_id: string;
        }
        export interface GraduateExitSurveyList {
            btn: string;
            end_date: string;
            session: string;
            session_id: string;
            slno?: number;
            start_date: string;
            status: string;
            survey: string;
            survey_id: string;
        }
        export interface GraduateExitSurveyListResponse {
            gesurvey: Array<GraduateExitSurveyList>;
        }
    }
    export namespace courseevaluation {
        export interface CourseSurvey {
            btn: string;
            end_date: string;
            session: string;
            session_id: string;
            slno?: number;
            start_date: string;
            status: string;
            survey: string;
        }
        export interface CourseSurveyOptions {
            option: string;
            option_id: string;
        }
        export interface CourseSurveyQuestions {
            answer_id: string;
            options: Array<CourseSurveyOptions>;
            q_id: string;
            question: string;
            required?: boolean;
            slno?: number;
        }
        export interface CourseSurveyQuestionsResponse {
            login?: boolean;
            questions: Array<CourseSurveyQuestions>;
        }
        export interface CourseSurveyResponse {
            login?: boolean;
            survey: Array<CourseSurvey>;
        }
        export interface DoCourseSurvey {
            btn: string;
            id: string;
            name: string;
            slno?: number;
            status: string;
        }
        export interface DoCourseSurveyResponse {
            description: string;
            login?: boolean;
            period: string;
            session: string;
            subjects: Array<DoCourseSurvey>;
            type: string;
        }
    }
}
export namespace subjectregistration {
    export interface Category {
        name: string;
        subjects: Array<Subject>;
    }
    export interface PathWay {
        id?: number;
        name: string;
    }
    export interface SemList {
        sem_pos?: number;
        subjects: Array<SubjectMainList>;
    }
    export interface SemSubList {
        ans: string;
        id?: number;
        name: string;
    }
    export interface SemSubjects {
        group: string;
        mark: string;
        subject_name: string;
    }
    export interface SemesterList {
        mdc_subjects: Array<SemSubjects>;
        minor_subjects: Array<SemSubjects>;
        seme_pos: string;
        sgpa: string;
    }
    export interface StatusList {
        name: string;
        status: string;
    }
    export interface Subject {
        id: string;
        name: string;
        preference: string;
        status: string;
    }
    export interface SubjectMainList {
        ans: string;
        mark: string;
        name: string;
        sem_id?: number;
        subjects: Array<SemSubList>;
    }
    export interface SubjectRegistration {
        added_at: string;
        category: string;
        id: string;
        semester: string;
        status: Array<StatusList>;
    }
    export interface SubjectRegistrationResponse {
        data: Array<SubjectRegistration>;
        error: string;
    }
    export interface SubjectSpinner {
        id?: number;
        name: string;
    }
    export interface SubjectSpinnerResponse {
        additionalelective_1: Array<SubjectSpinner>;
        additionalelective_2: Array<SubjectSpinner>;
        additionalelective_3: Array<SubjectSpinner>;
        aec_1: Array<SubjectSpinner>;
        aec_2: Array<SubjectSpinner>;
        aec_3: Array<SubjectSpinner>;
        dsc_1: Array<SubjectSpinner>;
        dsc_2: Array<SubjectSpinner>;
        dsc_3: Array<SubjectSpinner>;
        elective_1: Array<SubjectSpinner>;
        elective_2: Array<SubjectSpinner>;
        elective_3: Array<SubjectSpinner>;
        globalelective: Array<SubjectSpinner>;
        honour: Array<SubjectSpinner>;
        mdc_1: Array<SubjectSpinner>;
        mdc_2: Array<SubjectSpinner>;
        mdc_3: Array<SubjectSpinner>;
        minor_1: Array<SubjectSpinner>;
        minor_2: Array<SubjectSpinner>;
        minor_3: Array<SubjectSpinner>;
    }
    export interface Subjects {
        ans: string;
        id?: number;
        name: string;
    }
    export interface SubjectsList {
        id?: number;
        name: string;
        subjects: Array<Subjects>;
    }
    export interface SubjectsListResponse {
        category: Array<PathWay>;
        pathway: Array<PathWay>;
        sem_list: Array<SemList>;
        subject_list: Array<SubjectsList>;
    }
    export interface ViewSubjectRegistrationResponse {
        admission_no: string;
        can_update?: boolean;
        category: string;
        data: Array<Category>;
        full_name: string;
        path_way: string;
        previousdata: Array<SemesterList>;
        sem_id: string;
        semester: string;
    }
}
export namespace subject {
    export interface Subjects {
        atten_per: string;
        atten_text: string;
        isSubGe?: boolean;
        sub_id: string;
        sub_name: string;
        teacher_name: string;
    }
    export namespace syllabus {
        export interface Syllabus {
            module: string;
            topics: Array<Topic>;
        }
        export interface SyllabusResponse {
            syllabus: Array<Syllabus>;
        }
        export interface Topic {
            topic: string;
        }
    }
    export namespace coverage {
        export interface SubCovTopic {
            is_covered?: boolean;
            topic_name: string;
        }
        export interface SubCoverage {
            module: string;
            ratio?: number;
            topic: Array<SubCovTopic>;
        }
        export interface SubCoverageResponse {
            coverage: Array<SubCoverage>;
            login?: boolean;
        }
    }
    export namespace co {
        export interface CoModel {
            co_id: string;
            topic: string;
        }
        export interface CoSyllabusRequest {
            sub_id: string;
        }
    }
}
export namespace store {
    export interface SemesterListRequest {
        dept_id: string;
    }
    export interface Store {
        name: string;
        price: string;
    }
    export interface StoreRequest {
        subject_id: string;
    }
    export interface StoreResponse {
        data: Array<Store>;
        login?: boolean;
        success?: boolean;
    }
    export namespace departmentlist {
        export interface DepartmentList {
            id: string;
            name: string;
        }
        export interface DepartmentListResponse {
            data: Array<DepartmentList>;
            login?: boolean;
            success?: boolean;
        }
    }
}
export namespace stationary {
    export interface AdvancePaymentResponse {
        login?: boolean;
        success?: boolean;
        url: string;
    }
    export interface StationaryItem {
        category_id: string;
        category_name: string;
        id: string;
        name: string;
        pre_url: string;
        price: string;
        subcategory_id: string;
        subcategory_name: string;
    }
    export interface StationaryItemResponse {
        data: Array<StationaryItem>;
    }
    export interface StationaryReceipt {
        create_time: string;
        created_user: string;
        id: string;
        method: string;
        print_url: string;
        receipt_date: string;
        receipt_no: string;
        status: string;
        total_amount: string;
        view_url: string;
    }
    export interface StationaryReceiptResponse {
        data: Array<StationaryReceipt>;
        login?: boolean;
    }
}
export namespace semregistration {
    export interface AcademicYear {
        id?: number;
        name: string;
    }
    export interface AcademicYearResponse {
        additional_electives: Array<AcademicYear>;
        electives: Array<AcademicYear>;
        globalelectives: Array<AcademicYear>;
        honours: Array<AcademicYear>;
        login?: boolean;
        minors: Array<AcademicYear>;
        program_electives: Array<AcademicYear>;
        semester: string;
        semester_id: string;
    }
    export interface SemRegViewResponse {
        academic_due: string;
        academic_due_details: string;
        accounts_due: string;
        accounts_due_details: string;
        admission_no: string;
        amount_paid: string;
        backpaper: string;
        backlogs_count: string;
        bank_name: string;
        bus_due: string;
        bus_due_details: string;
        can_edit?: boolean;
        can_edit_message: string;
        classteacher_remarks: string;
        department_due: string;
        department_due_details: string;
        earned_credits: string;
        email: string;
        exam_appear: string;
        exam_month_year: string;
        fee_concession: string;
        fee_concession_category: string;
        fee_exemption?: boolean;
        fee_paid: string;
        feereceipt_file: string;
        gender: string;
        hod_remarks: string;
        hostel_due: string;
        hostel_due_details: string;
        is_applied?: boolean;
        last_attended_sem: string;
        last_attended_sem_text: string;
        library_due: string;
        librarary_due_details: string;
        login?: boolean;
        name: string;
        payment_date: string;
        payment_mode: string;
        payment_reference_no: string;
        phone: string;
        regslip_file: string;
        sem_applied_for: string;
        sem_list: Array<Semester>;
        sem_registration_status?: boolean;
        sem_registration_status_message: string;
        status: string;
        unireg_no: string;
        update_btn?: boolean;
    }
    export namespace view {
        export interface SemRegSlip {
            login?: boolean;
            regslip_file: string;
            success?: boolean;
        }
    }
    export namespace list {
        export interface RegisterList {
            date: string;
            id: string;
            semester_applied_from: string;
            status: string;
        }
        export interface SemRegisterListResponse {
            due_status?: boolean;
            sem_registration_error: string;
            fee_exemption?: boolean;
            fee_paid?: boolean;
            hostel_due_message: string;
            hostel_due_status?: boolean;
            login?: boolean;
            register_list: Array<RegisterList>;
            sem_registration_status?: boolean;
            sem_registration_status_message: string;
        }
    }
}
export namespace result {
    export interface ResultAssignment {
        max_mark: string;
        name: string;
        obtained_mark: string;
        subject: string;
    }
    export interface ResultInternal {
        max_mark: string;
        obtained_mark: string;
        subject: string;
    }
    export interface ResultSeasonal {
        max_mark: string;
        obtained_mark: string;
        subject: string;
    }
    export interface SeasonRequest {
        sem_id: string;
        session: string;
    }
    export namespace univ {
        export interface UnivDetails {
            cgpa?: string;
            credit?: string;
            pass_status?: string;
            sgpa?: string;
            total_internal?: string;
        }
        export interface UnivExamSubjects {
            attendance?: string;
            credits?: string;
            internal_mark?: string;
            status?: string;
            subject?: string;
            univ_mark?: string;
        }
        export interface UnivExams {
            exam_name: string;
            subjects: Array<UnivExamSubjects>;
        }
        export interface UnivResponse {
            details: UnivDetails;
            error: string;
            login?: boolean;
            subjects: Array<UnivSubjects>;
            univ_exams: Array<UnivExams>;
        }
        export interface UnivSubjects {
            status?: string;
            subject?: string;
        }
    }
    export namespace tutorial {
        export interface TutorialResult {
            mark: string;
            subject: string;
            title: string;
        }
        export interface TutorialResultResponse {
            error: string;
            login?: boolean;
            tutorials: Array<TutorialResult>;
        }
    }
    export namespace moduletest {
        export interface ResultModuleTest {
            mark: string;
            subject: string;
        }
        export interface ResultModuleTestResponse {
            login?: boolean;
            module_test: Array<ResultModuleTest>;
        }
    }
}
export namespace resetpassword {
    export interface ResetPassword {
        url: string;
    }
    export interface ResetPasswordResponse {
        resets: Array<ResetPassword>;
    }
}
export namespace quiz {
    export interface OptionsNew {
        id: string;
        option: string;
    }
    export interface QuestionsNew {
        answer_id?: string;
        duration_in_seconds?: string;
        id?: string;
        file?: string;
        is_attended?: boolean;
        options: Array<OptionsNew>;
        qno?: string;
        question_text: string;
        question_type?: string;
        session_id?: string;
        user_answer?: string;
    }
    export interface QuestionsNewResponse {
        questions: Array<QuestionsNew>;
    }
    export namespace submit {
        export interface QuizFinishRequest {
            final_submit: string;
            option?: string;
            qno?: string;
        }
        export interface QuizSubmitResponse {
            is_ongoing?: boolean;
            is_started?: boolean;
            is_finished?: boolean;
            success?: boolean;
        }
        export interface SubmitRequest {
            option?: string;
            qno?: string;
        }
    }
    export namespace result {
        export interface QuizResultResponse {
            descriptive_questions: Array<quiz.result.descriptive.DescriptiveQuestions>;
            file_upload_questions: Array<quiz.result.filetype.FileTypeQuestions>;
            has_result_published?: boolean;
            has_student_attended?: boolean;
            login?: boolean;
            marks_scored: string;
            multiple_choice_questions: Array<quiz.result.mcq.McqQuestions>;
            question_set_name: string;
        }
        export namespace mcq {
            export interface McqOptions {
                id?: string;
                option_content?: string;
            }
            export interface McqQuestions {
                correct_option_id?: string;
                is_answer_correct?: boolean;
                is_attended?: boolean;
                mark_obtained?: string;
                question_content?: string;
                question_no?: string;
                question_options: Array<McqOptions>;
                user_opted_option_id?: string;
            }
        }
        export namespace filetype {
            export interface FileTypeQuestions {
                file: Array<QuizResultFile>;
                is_attended?: boolean;
                mark_obtained?: string;
                question_content?: string;
                question_no?: string;
            }
            export interface QuizResultFile {
                name?: string;
                path?: string;
            }
        }
        export namespace descriptive {
            export interface DescriptiveQuestions {
                is_attended?: boolean;
                mark_obtained?: string;
                question_content?: string;
                question_no?: string;
                student_answer?: string;
            }
        }
    }
    export namespace questions {
        export interface Options {
            id?: string;
            option?: string;
        }
        export interface QuestionResponse {
            questions: Array<Questions>;
        }
        export interface Questions {
            answer_id?: string;
            duration_in_seconds?: string;
            id?: string;
            file?: string;
            is_attended?: boolean;
            options: Array<Options>;
            qno?: string;
            question_text?: string;
            question_type?: string;
            session_id?: string;
            user_answer?: string;
        }
    }
    export namespace list {
        export interface Quiz {
            description: string;
            end_time: string;
            id: string;
            isCompleted?: boolean;
            isOnGoing?: boolean;
            isResultPublished?: boolean;
            isStarted?: boolean;
            max_mark: string;
            name: string;
            start_time: string;
            statusText: string;
            type: string;
            typeText: string;
        }
        export interface QuizResponse {
            quizes: Array<Quiz>;
        }
    }
    export namespace file {
        export interface QuizDeleteFile {
            file_id: string;
        }
        export interface QuizFileUploadResponse {
            delete_url: string;
            id: string;
            name: string;
            url: string;
        }
    }
}
export namespace programoutcome {
    export interface ProgramOutcome {
        content: string;
        heading: string;
    }
    export interface ProgramOutcomeResponse {
        login?: boolean;
        pgm_educational: Array<ProgramOutcome>;
        pgm_outcomes: Array<ProgramOutcome>;
        pgm_specific: Array<ProgramOutcome>;
    }
}
export namespace profileasiet {
    export namespace sport {
        export interface Sport {
            awards: string;
            date: string;
            event: string;
            file: string;
            id: string;
            level: string;
            name: string;
            organized_by: string;
            type: string;
            year: string;
        }
        export interface SportResponse {
            login?: boolean;
            participation: Array<Sport>;
        }
    }
    export namespace scholarships {
        export interface Scholarships {
            id: string;
            name: string;
            type: string;
            year: string;
        }
        export interface ScholarshipsResponse {
            login?: boolean;
            scholarship: Array<Scholarships>;
        }
    }
    export namespace qualifiedexamination {
        export interface QualifiedExamination {
            file: string;
            id: string;
            name: string;
            score: string;
            year: string;
        }
        export interface QualifiedExaminationResponse {
            examination: Array<QualifiedExamination>;
            login?: boolean;
        }
    }
    export namespace publication {
        export interface Publication {
            conference: string;
            file: string;
            id: string;
            index: string;
            journal: string;
            title: string;
            year: string;
        }
        export interface PublicationDropDown {
            id?: number;
            name: string;
        }
        export interface PublicationDropDownResponse {
            category: Array<PublicationDropDown>;
            index: Array<PublicationDropDown>;
            level: Array<PublicationDropDown>;
            login?: boolean;
            membership: Array<PublicationDropDown>;
            nature: Array<PublicationDropDown>;
            project: Array<PublicationDropDown>;
            scholarship: Array<PublicationDropDown>;
            sem_id: string;
            sem_name: string;
            years: Array<PublicationDropDown>;
        }
        export interface PublicationResponse {
            login?: boolean;
            publications: Array<Publication>;
        }
    }
    export namespace projectwork {
        export interface ProjectWork {
            details: string;
            file: string;
            id: string;
            type: string;
            year: string;
        }
        export interface ProjectWorkResponse {
            login?: boolean;
            project: Array<ProjectWork>;
        }
    }
    export namespace positionheld {
        export interface PositionHeld {
            end: string;
            id: string;
            name: string;
            start: string;
            year: string;
        }
        export interface PositionHeldResponse {
            login?: boolean;
            positions: Array<PositionHeld>;
        }
    }
    export namespace mooccourse {
        export interface MoocCourse {
            achievements: string;
            duration: string;
            file: string;
            from_date: string;
            id: string;
            name: string;
            platform: string;
            to_date: string;
        }
        export interface MoocCourseResponse {
            login?: boolean;
            mooc: Array<MoocCourse>;
        }
    }
    export namespace membership {
        export interface Membership {
            description: string;
            file: string;
            id: string;
            member_id: string;
            member_since: string;
            name: string;
            type: string;
        }
        export interface MembershipResponse {
            login?: boolean;
            professionalsociety: Array<Membership>;
        }
    }
    export namespace fundedresearch {
        export interface FundedResearch {
            agency: string;
            amount: string;
            duration: string;
            file: string;
            id: string;
            title: string;
            year: string;
        }
        export interface FundedResearchResponse {
            funded: Array<FundedResearch>;
            login?: boolean;
        }
    }
    export namespace coursesattended {
        export interface CoursesAttended {
            achievements: string;
            duration: string;
            file: string;
            from_date: string;
            id: string;
            name: string;
            organized_by: string;
            to_date: string;
            year: string;
        }
        export interface CoursesAttendedResponse {
            courses: Array<CoursesAttended>;
            login?: boolean;
        }
    }
    export namespace achievements {
        export interface Achievements {
            file: string;
            id: string;
            name: string;
            year: string;
        }
        export interface AchievementsResponse {
            achievement: Array<Achievements>;
            login?: boolean;
        }
    }
}
export namespace placement {
    export interface Placement {
        btn?: boolean;
        date: string;
        description: string;
        id: string;
        last_date: string;
        name: string;
        status: string;
    }
    export interface PlacementRequest {
        placement_id: string;
    }
}
export namespace onlineclass {
    export interface OnlineClass {
        sub_name: string;
        suburl: string;
    }
    export interface OnlineClassResponse {
        batch: string;
        batchvideourl: string;
        error: string;
        login?: boolean;
        subjects: Array<OnlineClass>;
        semester: string;
    }
}
export namespace noticeboard {
    export interface Notice {
        content: string;
        "create by": string;
        "created time": string;
        document: string;
        heading: string;
    }
    export interface NoticeJecc {
        content: string;
        "create by": string;
        "created time": string;
        document: string;
        heading: string;
    }
    export interface NoticeJeccResponse {
        error: string;
        login?: boolean;
        notice: Array<NoticeJecc>;
    }
    export interface NoticeResponse {
        error: string;
        login?: boolean;
        notice: Array<Notice>;
    }
}
export namespace message {
    export interface Inbox {
        content: string;
        date: string;
        from: string;
        id: string;
        is_read: string;
        sender_id: string;
        subject: string;
    }
    export interface MsgHandleRequest {
        id: string;
    }
    export interface Outbox {
        content: string;
        date: string;
        id: string;
        subject: string;
        to: string;
    }
    export interface ReplyRequest {
        message: string;
        reply_for_id?: string;
        to_id?: string;
    }
}
export namespace mess {
    export interface Mess {
        day: string;
        items: Array<MessMenu>;
    }
    export interface MessData {
        booking_date: string;
        day: string;
        day_id: string;
    }
    export interface MessItem {
        id: string;
        max_qty: string;
        name: string;
    }
    export interface MessMenu {
        max_qty: string;
        menu: string;
        type?: number;
        type_name: string;
    }
    export interface MessMenuResponse {
        item: Array<MessItem>;
        login?: boolean;
    }
    export interface MessResponse {
        data: Array<Mess>;
        login?: boolean;
    }
    export interface MessType {
        id: string;
        name: string;
    }
    export interface MessTypeResponse {
        data: Array<MessData>;
        login?: boolean;
        type: Array<MessType>;
    }
    export interface OrderHistory {
        booking_date: string;
        id: string;
        menu: string;
        quantity: string;
        status: string;
        type: string;
    }
    export interface OrderHistoryResponse {
        data: Array<OrderHistory>;
        login?: boolean;
    }
}
export namespace materials {
    export interface DownloadMaterial {
        url: string;
    }
    export interface DownloadMaterialResponse {
        files: Array<DownloadMaterial>;
    }
    export interface MaterialRequest {
        sem_id: string;
    }
    export interface Materials {
        date: string;
        link: string;
        module: string;
        semester: string;
        subject: string;
        title: string;
        url: string;
    }
    export interface MaterialsNew {
        date: string;
        download: string;
        link: string;
        module: string;
        semester: string;
        subject: string;
        title: string;
        url: Array<string>;
    }
}
export namespace main {
    export interface ApplyHostelResponse {
        error: string;
        hostel?: number;
        hostel_status: string;
        login?: boolean;
        success?: boolean;
    }
    export interface CourseSurveyPending {
        coursesurvey_status?: boolean;
    }
    export interface FeeStatusResponse {
        error: string;
        login?: boolean;
        status?: boolean;
    }
    export interface POSurveyPending {
        posurvey_status?: boolean;
    }
    export interface PushRequest {
        platform: string;
        token: string;
    }
    export interface PushResponse {
        error: string;
        login?: boolean;
        success?: boolean;
    }
    export interface SurveyMandatory {
        login?: boolean;
        survey_mandatory?: boolean;
    }
    export interface SurveyPending {
        profile_status?: boolean;
        semreg_default?: boolean;
        survey_status?: boolean;
    }
}
export namespace login {
    export interface LoginRequest {
        hostel?: string;
        password: string;
        username: string;
    }
    export interface LoginResponse {
        academic_year: string;
        access_token: string;
        batch_id: string;
        course: string;
        end_year?: number;
        error: string;
        hostel?: number;
        hostel_status: string;
        isktu?: boolean;
        login?: boolean;
        logout_status: string;
        password: string;
        url: string;
        profile_name: string;
        sem_id: string;
        sem_name: string;
        start_year?: number;
        univ: string;
        user_type: string;
        uname: string;
    }
    export interface LogoutRequest {
        push_token: string;
    }
}
export namespace live {
    export interface Live {
        date: string;
        details: string;
        link: string;
        title: string;
        type: string;
    }
    export interface LiveResponse {
        live: Array<Live>;
        login?: boolean;
    }
}
export namespace library {
    export interface BookRecord {
        due_date: string;
        fine: string;
        is_paid: string;
        issue_date: string;
        remarks: string;
        renewal_date: string;
        returned_date: string;
        slno: string;
        status: string;
        title: string;
    }
    export interface BookRecordResponse {
        book_record: Array<BookRecord>;
        login?: boolean;
    }
    export interface Books {
        author: string;
        bookid: string;
        category: string;
        distribution: string;
        edition: string;
        isbn: string;
        location: string;
        name: string;
        slno: string;
        status: string;
        title: string;
    }
    export interface BooksResponse {
        books: Array<Books>;
        login?: boolean;
    }
}
export namespace leavemanagement {
    export interface LeaveManagement {
        allocated_leave: string;
        balance?: number;
        id?: number;
        leave_type: string;
        staff_id: string;
        taken?: number;
    }
    export interface LeaveManagementResponse {
        leave_data: Array<LeaveManagement>;
        login?: boolean;
        success?: boolean;
    }
}
export namespace leave {
    export namespace medical {
        export interface MedicalLeave {
            datefrom: string;
            dateto: string;
            reason: string;
            remark: string;
            status: string;
        }
        export interface MedicalRequest {
            from_date: string;
            to_date: string;
            reason: string;
        }
    }
    export namespace duty {
        export interface DutyLeave {
            btn_status?: boolean;
            description: string;
            id: string;
            l_date: string;
            name: string;
            proof_status?: boolean;
            proof_url: string;
            status: string;
            type: string;
        }
        export interface DutyLeaveDate {
            date: string;
            hours: Array<DutyLeaveHour>;
            selected?: boolean;
        }
        export interface DutyLeaveDateResponse {
            data: Array<DutyLeaveDate>;
            login?: boolean;
        }
        export interface DutyLeaveDirectApply {
            from_date: string;
            head: string;
            id: string;
            reason: string;
            status: string;
            to_date: string;
            url: string;
        }
        export interface DutyLeaveDirectApplyResponse {
            data: Array<DutyLeaveDirectApply>;
            login?: boolean;
        }
        export interface DutyLeaveHead {
            id?: number;
            name: string;
        }
        export interface DutyLeaveHeadResponse {
            data: Array<DutyLeaveHead>;
            login?: boolean;
        }
        export interface DutyLeaveHour {
            hour?: number;
            status: string;
        }
        export interface DutyLeaveViewRequest {
            filter: string;
        }
    }
}
export namespace lab {
    export interface Evaluation {
        output: string;
        record: string;
        topic: string;
        viva: string;
    }
    export interface LabDue {
        amount: string;
        due_date: string;
        equipment: string;
        lab: string;
        paid_date: string;
        paid_status: string;
    }
    export interface LabEquipRequest {
        lid?: string;
    }
    export interface LabEquipment {
        asset_type: string;
        facility_name: string;
        status: string;
        type: string;
    }
    export interface LabList {
        id: string;
        laboratary_name: string;
    }
    export interface Practical {
        atten_text: string;
        sub_id: string;
        sub_pid: string;
        subject: string;
    }
    export interface PracticalRequest {
        sub_id?: string;
        sub_pid?: string;
    }
}
export namespace internship {
    export interface Internship {
        completion_certificate: string;
        from_date: string;
        id: string;
        name: string;
        slno: string;
        status: string;
        to_date: string;
        url: string;
        verified_certificate: string;
    }
    export interface InternshipResponse {
        data: Array<Internship>;
        login?: boolean;
    }
    export namespace companylist {
        export interface CompanyList {
            id: string;
            name: string;
        }
        export interface CompanyListResponse {
            companies: Array<CompanyList>;
            login?: boolean;
        }
    }
}
export namespace institutions {
    export interface Colleges {
        base_url: string;
        clgId: string;
        clgName: string;
        regUrl: string;
    }
    export interface Institution {
        colleges: Array<Colleges>;
    }
}
export namespace hostelnew {
    export interface HostelNewAdmission {
        amount?: number;
        balance?: number;
        fine?: number;
        installment: string;
        is_selected?: boolean;
        m: string;
        month: string;
        paid?: number;
        payment: Array<hostel.HostelFee>;
        y: string;
        year: string;
    }
    export interface HostelNewAdmissionResponse {
        date: string;
        fine: string;
        hostel: Array<HostelNewAdmission>;
        login?: boolean;
    }
    export interface HostelNewHistory {
        adjustment?: number;
        amount?: number;
        balance?: number;
        installment: string;
        paid?: number;
        wallet?: number;
    }
    export interface HostelNewHistoryResponse {
        admission_history: Array<HostelNewHistory>;
        login?: boolean;
        monthly_history: Array<HostelNewHistory>;
    }
    export interface HostelNewMonthly {
        amount?: number;
        balance?: number;
        fine?: number;
        installment: string;
        is_selected?: boolean;
        m: string;
        month: string;
        paid?: number;
        payment: Array<hostel.HostelFee>;
        y: string;
        year: string;
    }
    export interface HostelNewMonthlyResponse {
        date: string;
        fine: string;
        hostel: Array<HostelNewMonthly>;
        login?: boolean;
    }
    export interface HostelNewPay {
        fine?: number;
        subtotal?: number;
        total_amount?: number;
        url: string;
    }
    export interface HostelStatusNew {
        allpayment?: boolean;
        login?: boolean;
    }
}
export namespace hostel {
    export interface HostelFee {
        adjustment?: number;
        amount: string;
        balance?: number;
        feegroup_id: string;
        feehead_id: string;
        feeheadgroup_id: string;
        feetype: string;
        fine?: number;
        hostel_id: string;
        installment?: number;
        name: string;
        paid?: number;
        payable?: number;
        scholarship: string;
        status?: number;
        tenant_id: string;
        user_id: string;
    }
    export interface HostelFeePalaiResponse {
        fine?: number;
        subtotal?: number;
        total?: number;
        url: string;
    }
    export interface HostelFeeRequest {
        transaction_method: string;
        month: string;
        year: string;
    }
    export interface HostelFeeResponse {
        url: string;
    }
    export interface HostelFeeTypes {
        id?: number;
        name: string;
    }
    export interface HostelMonth {
        amount?: number;
        balance?: number;
        diff: string;
        fine: string;
        installment: string;
        is_selected?: boolean;
        m: string;
        month: string;
        paid?: number;
        payment: Array<HostelFee>;
        y: string;
        year: string;
    }
    export interface HostelMonthResponse {
        date: string;
        hostel: Array<HostelMonth>;
        login?: boolean;
    }
    export interface HostelPalaiAdmission {
        amount?: number;
        balance?: number;
        diff: string;
        fine?: number;
        installment: string;
        is_selected?: boolean;
        m: string;
        month: string;
        paid?: number;
        payment: Array<HostelFee>;
        scholarship: string;
        y: string;
        year: string;
    }
    export interface HostelPalaiAdmissionResponse {
        date: string;
        fine: string;
        hostel: Array<HostelPalaiAdmission>;
        login?: boolean;
        method: string;
        types: Array<HostelFeeTypes>;
    }
    export interface HostelPalaiMonth {
        amount?: number;
        balance?: number;
        diff: string;
        fine: string;
        installment: string;
        m: string;
        month: string;
        paid?: number;
        payment: Array<HostelFee>;
        y: string;
        year: string;
    }
    export interface HostelPalaiResponse {
        date: string;
        hostel: Array<HostelPalaiMonth>;
        login?: boolean;
    }
    export interface HostelPalaiTypesResponse {
        login?: boolean;
        types: Array<HostelFeeTypes>;
    }
    export interface HostelResponse {
        hostel: string;
        installment: string;
        join_date: string;
        month: string;
        name: string;
        room_no: string;
        year: string;
    }
    export namespace receipt {
        export interface HostelReceipt {
            amount: string;
            feeReceiptNo: string;
            hostel: string;
            installment: string;
            receipt_date: string;
            receipt_url: string;
        }
        export interface HostelReceiptResponse {
            receipts: Array<HostelReceipt>;
        }
    }
    export namespace partial {
        export namespace admission {
            export interface HostelPartialAdmission {
                date: string;
                fine: string;
                login?: boolean;
                payment: Array<HostelPartialPayment>;
            }
            export interface HostelPartialAdmissionResponse {
                date: string;
                fine: string;
                hostel: Array<HostelPartialAdmission>;
                login?: boolean;
                method: string;
                types: Array<hostel.HostelFeeTypes>;
            }
            export interface HostelPartialPayment {
                amount: string;
                balance?: number;
                feehead_id: string;
                feeheadgroup_id: string;
                feetype: string;
                hostel_id: string;
                installment?: number;
                is_selected?: boolean;
                m: string;
                name: string;
                paid?: number;
                payable?: number;
                scholarship?: number;
                status?: number;
                tenant_id: string;
                user_id: string;
                y: string;
            }
        }
    }
    export namespace mits {
        export interface MitsFeePay {
            login?: boolean;
            url: string;
        }
    }
    export namespace gcekhostel {
        export namespace reregistration {
            export interface PresentHostel {
                id?: number;
                name: string;
            }
            export interface PresentHostelResponse {
                hostel: Array<PresentHostel>;
                login?: boolean;
            }
        }
        export namespace registration {
            export interface Registration {
                added_at: string;
                id: string;
                print: string;
                reg_type: string;
                semester: string;
                status: string;
            }
            export interface RegistrationResponse {
                is_hostler?: boolean;
                login?: boolean;
                re_admission?: boolean;
                reg: Array<Registration>;
            }
            export interface ViewRegistrationResponse {
                admission_no: string;
                admsn_type: string;
                annual_income: string;
                blood_group: string;
                caste: string;
                category: string;
                distance: string;
                full_name: string;
                guardian_address: string;
                incomeFile: string;
                login?: boolean;
                phone_guardian: string;
                phone_no: string;
                punishment: string;
                readmission: string;
                religion: string;
                remarks: string;
                semester: string;
                status: string;
                type: string;
            }
        }
        export namespace newregistration {
            export interface CategoryType {
                id?: number;
                name: string;
            }
            export interface CategoryTypeResponse {
                category: Array<CategoryType>;
                login?: boolean;
            }
        }
    }
    export namespace attendance {
        export interface HostelAttCalResponse {
            absent: Array<boolean>;
            leaves: Array<boolean>;
            login?: boolean;
            monthdate: Array<string>;
            present: Array<boolean>;
            rejects: Array<boolean>;
        }
        export interface HostelAttParentView {
            btn_app: string;
            btn_rej: string;
            btn_rev: string;
            from_date: string;
            id: string;
            reason: string;
            status: string;
            type: string;
        }
        export interface HostelAttParentViewResponse {
            data: Array<HostelAttParentView>;
            login?: boolean;
        }
        export interface HostelAttView {
            btn_already_exit?: boolean;
            btn_del?: boolean;
            btn_download?: boolean;
            btn_exit?: boolean;
            date: string;
            id: string;
            reason: string;
            status: string;
            type: string;
            url: string;
        }
        export interface HostelAttViewResponse {
            data: Array<HostelAttView>;
            login?: boolean;
        }
        export interface HostelScanViewResponse {
            address: string;
            date: string;
            from_date: string;
            hostel: string;
            image: string;
            login?: boolean;
            name: string;
            phone_no: string;
            qrcode: string;
            reason: string;
            room: string;
            status: string;
            type: string;
            url: string;
        }
        export interface LeaveType {
            id?: number;
            type: string;
        }
        export interface LeaveTypeResponse {
            data: Array<LeaveType>;
            login?: boolean;
        }
    }
    export namespace asiet {
        export interface AsietBoarding {
            amount: string;
            id: string;
            name: string;
        }
        export interface History {
            id: string;
            name: string;
            reg_date: string;
            start_date: string;
            status: string;
            year: string;
        }
        export interface HostelAsietRegisterViewResponse {
            admission_no: string;
            batch: string;
            boardings: Array<AsietBoarding>;
            declaration: string;
            full_name: string;
            history: Array<History>;
            login?: boolean;
            note: string;
            route_url: string;
        }
    }
}
export namespace homework {
    export interface HomeWork {
        can_submit?: boolean;
        details: string;
        files: Array<exam.ExamFiles>;
        id: string;
        issued_date: string;
        last_date: string;
        late_submission_date: string;
        late_submission_status: string;
        semester: string;
        status: string;
        subject: string;
        teacher_feedback: string;
        title: string;
        type: string;
        uploaded_file: string;
    }
    export interface HomeWorkResponse {
        homeworks: Array<HomeWork>;
        login?: boolean;
    }
}
export namespace grievance {
    export interface Grievance {
        date: string;
        grievance_no: string;
        grievance_type: string;
        id: string;
        reminder: string;
        status: string;
        subject: string;
    }
    export interface GrievanceResponse {
        grievance: Array<Grievance>;
        login?: boolean;
    }
    export namespace view {
        export interface Actions {
            action_taken?: string;
            date?: string;
            level?: string;
        }
        export interface GrievanceDoc {
            doc?: string;
            path?: string;
        }
        export interface ViewGrievance {
            action_taken: string;
            date: string;
            description: string;
            gr_doc: Array<GrievanceDoc>;
            greivant: string;
            grievance_no: string;
            grievance_type: string;
            reply: string;
            reply_date: string;
            reply_details: string;
            reply_doc: Array<GrievanceDoc>;
            status: string;
            subject: string;
        }
        export interface ViewGrievanceResponse {
            actions: Array<Actions>;
            cellmembers: Array<string>;
            grievance: ViewGrievance;
            login?: boolean;
        }
    }
    export namespace type {
        export interface GrievanceType {
            id: string;
            name: string;
        }
        export interface GrievanceTypeResponse {
            g_types: Array<GrievanceType>;
            login?: boolean;
        }
    }
}
export namespace feepartial {
    export interface InstallmentDetails {
        balance: string;
        date: string;
        discount: string;
        editable_bal: string;
        feegroup_id: string;
        feehead: string;
        feeheadgroup_id: string;
        fees: string;
        paid: string;
        payable: string;
        scholarship: string;
    }
    export interface InstallmentDetailsResponse {
        installments: Array<InstallmentDetails>;
        login?: boolean;
        success?: boolean;
    }
    export interface InstallmentList {
        id: string;
        name: string;
    }
    export interface InstallmentListResponse {
        installments: Array<InstallmentList>;
        login?: boolean;
        success?: boolean;
    }
}
export namespace feemedical {
    export interface FeesMed {
        installment_id: string;
        installment_name: string;
        installments: Array<InstallmentsMed>;
    }
    export interface FeesMedResponse {
        fees: Array<FeesMed>;
        login?: boolean;
        success?: boolean;
    }
    export interface InstallmentsMed {
        balance: string;
        date: string;
        discount: string;
        feegroup_id: string;
        feehead: string;
        feehead_id: string;
        feeheadgroup_id: string;
        fees: string;
        paid: string;
        payable: string;
        scholarship: string;
    }
}
export namespace feeengineer {
    export namespace payment {
        export interface FeeEngineer {
            installment_id: string;
            installment_name: string;
            installments: Array<FeeEngineerInstallment>;
        }
        export interface FeeEngineerInstallment {
            balance: string;
            discount: string;
            feehead: string;
            feeheadgroup_id: string;
            fees: string;
            paid: string;
            payable: string;
            scholarship: string;
        }
        export interface FeeEngineerResponse {
            fees: Array<FeeEngineer>;
            login?: boolean;
            message: string;
            success?: boolean;
        }
        export interface FeeEngineerUrlResponse {
            error: string;
            fine: string;
            subtotal: string;
            total: string;
            url: string;
        }
    }
}
export namespace feearts {
    export namespace payment {
        export interface FeeArts {
            amount: string;
            balance?: number;
            fee_head_id: string;
            feegroup_id: string;
            feetype_id: string;
            installment_id: string;
            name: string;
            paid?: number;
            payable?: number;
            scholarship?: number;
        }
        export interface FeeArtsResponse {
            bal: string;
            date: string;
            fee_groups: Array<FeeArts>;
            fine: string;
            login?: boolean;
            student_id: string;
            success?: boolean;
            total: string;
        }
        export interface FeeArtsSemester {
            id?: number;
            name: string;
        }
        export interface FeeArtsSemesterResponse {
            installments: Array<FeeArtsSemester>;
            login?: boolean;
            success?: boolean;
        }
        export interface FeeArtsUrlResponse {
            url: string;
        }
    }
}
export namespace fee {
    export interface FeeGroups {
        amount: string;
        balance: string;
        feegroup_id: string;
        feeheadgroup_id: string;
        fee_head_id: string;
        feetype_id: string;
        name: string;
        paid: string;
        scholarship: string;
    }
    export interface FeeResponse {
        balance: string;
        date: string;
        fee_groups: Array<FeeGroups>;
        login?: boolean;
        message: string;
        paid: string;
        student_id: string;
        success?: boolean;
        total: string;
        url?: string;
    }
    export interface FeeSreeChitraUrl {
        login?: boolean;
        success?: boolean;
        url?: string;
    }
    export interface FeeUrlOnlyResponse {
        url?: string;
    }
    export interface FeeUrlResponse {
        error?: string;
        url?: string;
    }
    export interface GatewayDetailsResponse {
        address: string;
        ipg: string;
        login?: boolean;
        merchant: string;
        phone: string;
        refund: string;
    }
    export namespace receipts {
        export interface Receipt {
            amount: string;
            date: string;
            installment: string;
            method: string;
            receipt_no: string;
            refund_reason: string;
            refund_status?: boolean;
            status: string;
        }
        export interface ReceiptResponse {
            login?: boolean;
            message: string;
            receipts: Array<Receipt>;
            success?: boolean;
        }
    }
    export namespace installment {
        export interface InstallmentResponse {
            installments: Array<Installments>;
            login?: boolean;
            message: string;
            success?: boolean;
        }
        export interface Installments {
            id: string;
            name: string;
        }
    }
    export namespace feeheadgroups {
        export interface FeeHeadGroup {
            feeheadgroup_id: string;
        }
        export interface FeeHeadGroupResponse {
            fees: Array<FeeHeadGroup>;
        }
    }
}
export namespace examschedules {
    export interface ExamSchedule {
        date: string;
        details: string;
        exm_name: string;
        id: string;
        subject: string;
        time: string;
        url: string;
    }
    export interface ExamScheduleResponse {
        schedules: Array<ExamSchedule>;
    }
}
export namespace examregister {
    export interface ExamCourse {
        amount: string;
        course: string;
        feehead_id: string;
        is_eligible: string;
        is_selected?: boolean;
        no?: number;
        type: string;
    }
    export interface ExamCourseResponse {
        academicyear: string;
        admission_no: string;
        batch_id: string;
        can_update?: boolean;
        category: string;
        course: Array<ExamCourse>;
        degree: string;
        end_date: string;
        error: string;
        exam_year: string;
        is_registered?: boolean;
        login?: boolean;
        month: string;
        name: string;
        registration_slip?: boolean;
        semester: string;
        start_date: string;
    }
    export interface ExamMessage {
        amount: string;
        course: string;
        fineAmount: string;
        fixed_amount: string;
        is_eligible: string;
        totalAmount: string;
        type: string;
    }
    export interface ExamMessageResponse {
        error: string;
        exam: Array<ExamMessage>;
        is_registered?: boolean;
        login?: boolean;
        message: string;
        success?: boolean;
    }
    export interface ExamPay {
        amount: string;
        fineAmount: string;
        fixed_amount: string;
        totalAmount: string;
    }
    export interface ExamPayResponse {
        error: string;
        exam: Array<ExamPay>;
        is_registered?: boolean;
        login?: boolean;
        url: string;
    }
    export interface ExamReceipt {
        feeReceiptNo: string;
        print_url: string;
        receipt_date: string;
        sub_total: string;
    }
    export interface ExamReceiptResponse {
        login?: boolean;
        receipts: Array<ExamReceipt>;
    }
    export interface ExamRegister {
        id: string;
        name: string;
    }
    export interface ExamRegisterResponse {
        exam: Array<ExamRegister>;
        login?: boolean;
        notregexam: Array<ExamRegister>;
        regexam: Array<ExamRegister>;
    }
    export interface ExamUpdate {
        amount: string;
        course: string;
        feehead_id: string;
        is_eligible: string;
        is_selected?: boolean;
        msg: string;
        type: string;
    }
    export interface ExamUpdateResponse {
        admission_no: string;
        batch_id: string;
        exam: Array<ExamUpdate>;
        login?: boolean;
    }
    export interface ExamView {
        amount: string;
        course: string;
        is_eligible: string;
        type: string;
    }
    export interface ExamViewResponse {
        error: string;
        exam: Array<ExamView>;
        login?: boolean;
    }
    export interface RegistrationSlipResponse {
        file_url: string;
        login?: boolean;
    }
    export interface Revaluation {
        course: string;
        grade: string;
        status: string;
        type: string;
    }
    export interface RevaluationApply {
        answer_script: string;
        course: string;
        date: string;
        grade: string;
        revaluation: string;
        total: string;
        type: string;
    }
    export interface RevaluationApplyResponse {
        revaluation: Array<RevaluationApply>;
    }
    export interface RevaluationReceipt {
        answer_script: string;
        course: string;
        revaluation: string;
    }
    export interface RevaluationReceiptResponse {
        receipt: Array<RevaluationReceipt>;
        sub_total: string;
        total: string;
    }
    export interface RevaluationResponse {
        revaluation: Array<Revaluation>;
    }
    export interface RevaluationStatusResponse {
        status?: boolean;
    }
    export interface RevaluationUpdate {
        answer_script: string;
        course: string;
        grade: string;
        revaluation: string;
        status: string;
        type: string;
    }
    export interface RevaluationUpdateResponse {
        revaluation: Array<RevaluationUpdate>;
    }
    export interface RevaluationView {
        answer_script: string;
        course: string;
        revaluation: string;
        revaluation_id: string;
        total: string;
        type: string;
    }
    export interface RevaluationViewResponse {
        revaluation: Array<RevaluationView>;
    }
}
export namespace exam {
    export interface Exam {
        can_download?: boolean;
        can_submit?: boolean;
        files: Array<ExamFiles>;
        finish_time: string;
        id: string;
        is_delete?: boolean;
        semester: string;
        start_time: string;
        status: string;
        subject: string;
        title: string;
        uploaded_file: string;
    }
    export interface ExamFiles {
        doc?: string;
        path?: string;
    }
    export interface ModuleTestResponse {
        error: string;
        login?: boolean;
        module_test: Array<Exam>;
    }
    export interface SeriesExamResponse {
        error: string;
        login?: boolean;
        series_exams: Array<Exam>;
    }
}
export namespace due {
    export interface Due {
        admission_no: string;
        batch: string;
        due_amount: string;
        due_head: string;
        has_due: string;
        is_paid: string;
        student_name: string;
    }
    export interface DueResponse {
        due: Array<Due>;
        login?: boolean;
    }
    export namespace duepaynew {
        export interface DuePayNew {
            admission_no: string;
            amount: string;
            balance: string;
            date: string;
            department_id: string;
            due_id: string;
            error: string;
            fullpaid?: boolean;
            head_id: string;
            paid: string;
            sem_id: string;
            status: string;
            student_id: string;
            year_id: string;
        }
        export interface DuePayNewResponse {
            collect: Array<DuePayNew>;
        }
    }
    export namespace duepay {
        export interface DuePay {
            admission_no: string;
            amount: string;
            balance: string;
            date: string;
            department_id: string;
            due_id: string;
            head_id: string;
            installment: string;
            paid: string;
            status: string;
            student_id: string;
            year_id: string;
        }
        export interface DuePayResponse {
            dues: Array<DuePay>;
            login?: boolean;
        }
        export interface DuePayUrl {
            url: string;
        }
        export interface NoDueCertificateResponse {
            login?: boolean;
            url: string;
        }
    }
}
export namespace dash {
    export interface AbcResponse {
        abc_id: string;
        instructions: string;
        login?: boolean;
        video: string;
    }
    export interface DashRequest {
        hostel?: string;
    }
    export interface DashResponse {
        attendance_forthemonth: string;
        attendance_forthesem: string;
        bank_accno: string;
        bank_branch: string;
        bank_ifsc_code: string;
        bank_name: string;
        batch_id: string;
        clg_mission: string;
        clg_vision: string;
        course: string;
        curnt_sem: string;
        current_version?: number;
        dept_mission: string;
        dept_vision: string;
        due_new: string;
        error: string;
        fee_engnr_status?: boolean;
        fee_status?: boolean;
        hostel?: number;
        hostel_status: string;
        info_msg: string;
        live_tv_link: string;
        live_tv_type: string;
        login?: boolean;
        logout_status?: boolean;
        notices: Array<NoticesDash>;
        password_changed?: boolean;
        sem_id: string;
        semreg_default?: boolean;
        student_id: string;
        survey_message: string;
        survey_status?: boolean;
        timetable: Array<Array<timetable.TimeTable>>;
        url: string;
        url_sign: string;
        usertype: string;
        version_code?: number;
        version_code_aisat?: number;
        version_code_cep?: number;
        version_code_cetkr?: number;
        version_code_cev?: number;
        version_code_coet?: number;
        version_code_engnr?: number;
        version_code_gcei?: number;
        version_code_gcek?: number;
        version_code_gcekkd?: number;
        version_code_gecskp?: number;
        version_code_gectcr?: number;
        version_code_gecwyd?: number;
        version_code_jecc?: number;
        version_code_kmea?: number;
        version_code_kmeacoa?: number;
        version_code_mace?: number;
        version_code_marian?: number;
        version_code_mdit?: number;
        version_code_nssce?: number;
        version_code_sctce?: number;
        version_code_sjcetpalai?: number;
        version_code_tkmce?: number;
    }
    export interface LibraryResponse {
        login?: boolean;
        url: string;
    }
    export interface MaintenanceResponse {
        message: string;
        success?: boolean;
    }
    export interface NoticesDash {
        content: string;
    }
    export interface PendingSurvey {
        coursesurvey_status?: boolean;
        error: string;
        posurvey_status?: boolean;
        profile_status?: boolean;
        semreg_default?: boolean;
        survey_status?: boolean;
    }
    export interface ProfileResponse {
        address1: string;
        address2: string;
        address3: string;
        adharno: string;
        admission_no: string;
        bank_accno: string;
        bank_branch: string;
        bank_edit?: boolean;
        bank_ifsc_code: string;
        bank_name: string;
        bankdetail_status: string;
        blood_group: string;
        district: string;
        dob: string;
        edit_profile?: boolean;
        email: string;
        father_name: string;
        father_occupation: string;
        gender: string;
        mother_name: string;
        mother_occupation: string;
        name: string;
        nationality: string;
        phone_father: string;
        phone_home: string;
        phone_mother: string;
        pin: string;
        profile_edit_live?: boolean;
        register_no: string;
        religion: string;
        state: string;
    }
    export namespace daywisetimetaable {
        export interface DayWise {
            day: string;
            sub: Array<DayWiseTopicName>;
        }
        export interface DayWiseResponse {
            login?: boolean;
            timetable: Array<DayWise>;
        }
        export interface DayWiseTopicName {
            hour?: number;
            staff: string;
            subject: string;
            topic_name: Array<string>;
            type: string;
        }
    }
}
export namespace counselling {
    export interface Counselling {
        counselling_no: string;
        counselling_type: string;
        date: string;
        id: string;
        reminder: string;
        status: string;
    }
    export interface CounsellingResponse {
        login?: boolean;
        requests: Array<Counselling>;
    }
    export namespace view {
        export interface Actions2 {
            action_taken?: string;
            date?: string;
            level?: string;
        }
        export interface ViewCounselling {
            applicant: string;
            concern: string;
            counselling_history: string;
            counselling_session_required: string;
            counselling_type: string;
            date: string;
            id: string;
            impact_home: string;
            impact_physically_emotionally: string;
            impact_relationship: string;
            impact_studies: string;
        }
        export interface ViewCounsellingResponse {
            actions: Array<Actions2>;
            cell_members: Array<string>;
            login?: boolean;
            requests: ViewCounselling;
        }
    }
    export namespace type {
        export interface CounsellingTypes {
            id: string;
            name: string;
        }
        export interface CounsellingTypesResponse {
            c_types: Array<CounsellingTypes>;
            login?: boolean;
        }
    }
    export namespace status {
        export interface CounsellingStatus {
            id: string;
            name: string;
        }
        export interface CounsellingStatusResponse {
            data: Array<CounsellingStatus>;
            login?: boolean;
        }
    }
}
export namespace common {
    export interface Circular {
        date: string;
        description: string;
        heading: string;
        link: string;
        url: string;
    }
    export interface Remarks {
        remark: string;
        teacher: string;
    }
    export interface Teacher {
        image_url: string;
        t_email: string;
        t_phone: string;
        t_subject: string;
        t_name: string;
    }
    export interface TeacherResponse {
        hod: Array<Teacher>;
        staffadvisor: Array<Teacher>;
        sub_teacher: Array<Teacher>;
    }
}
export namespace chat {
    export namespace subjects {
        export interface Chat {
            batch_id: string;
            sem: string;
            subject: string;
            subject_id: string;
        }
        export interface ChatResponse {
            error: string;
            login?: boolean;
            subjects: Array<Chat>;
        }
    }
    export namespace reply {
        export interface Reply {
            img: string;
            name: string;
            reply: string;
            time: string;
        }
        export interface ReplyResponse {
            error: string;
            login?: boolean;
            reply: Array<Reply>;
        }
    }
    export namespace comment {
        export interface Comment {
            comment: string;
            comment_id: string;
            cmnt_user: string;
            img: string;
            reply: Array<chat.reply.Reply>;
            time: string;
        }
        export interface CommentResponse {
            comments: Array<Comment>;
            error: string;
            login?: boolean;
        }
    }
}
export namespace certificaterequest {
    export interface CertificateRequest {
        certificate_type: string;
        date_of_application: string;
        status: string;
    }
    export interface CertificateRequestResponse {
        history: Array<CertificateRequest>;
        error: string;
        login?: boolean;
    }
    export interface CertificateType {
        id: string;
        type: string;
    }
    export interface CertificateType2 {
        name: string;
    }
    export interface CertificateTypeResponse {
        certificate_type: Array<CertificateType>;
        class_selected: Array<CertificateType2>;
        error: string;
        login?: boolean;
        request_for: Array<CertificateType2>;
        request_opted: Array<CertificateType2>;
    }
}
export namespace centralizedinfo {
    export interface CentralizedInfo {
        date: string;
        link: string;
        title: string;
        type: string;
    }
    export interface CentralizedInfoResponse {
        info: Array<CentralizedInfo>;
        login?: boolean;
    }
}
export namespace calendar {
    export interface Calendar {
        date: string;
        subject: string;
    }
    export interface CalendarResponse {
        data: Array<Calendar>;
        error: string;
        login?: boolean;
    }
}
export namespace attendance {
    export interface Attendance {
        class_attended: string;
        credit_percent: string;
        credit_total: string;
        percentage: string;
        percentage_dutyleave: string;
        percentage_subject: string;
        subject: string;
        total_classes: string;
        total_dutyleave: string;
        total_subject: string;
    }
    export interface AttendanceDay {
        attendance: string;
        coverage: Array<string>;
        hour: string;
        subject: string;
    }
    export interface AttendanceDayRequest {
        date: string;
        semester: string;
    }
    export interface AttendanceDayResponse {
        attends: Array<AttendanceDay>;
    }
    export interface AttendanceNew {
        date: string;
        holiday?: boolean;
        periods: Array<AttendancePeriod>;
        totalperiod?: number;
    }
    export interface AttendanceNewResponse {
        attends: Array<AttendanceNew>;
    }
    export interface AttendancePeriod {
        attendance: string;
        hour?: number;
        subject: string;
    }
    export interface AttendanceRequest {
        sem_id: string;
    }
    export interface AttendanceRequestNew {
        month: string;
        semester: string;
        year: string;
    }
    export interface AttendanceResponse {
        error: string;
        login?: boolean;
        subjects: Array<Attendance>;
        total_credit: string;
        total_percent: string;
    }
}
export namespace assignment {
    export interface Assignment {
        can_download?: boolean;
        can_submit?: boolean;
        details: string;
        id: string;
        issue_date: string;
        last_date: string;
        semester: string;
        status: string;
        subject: string;
        title: string;
        upload?: boolean;
        uploaded_file: string;
        url: string;
    }
    export interface AssignmentRequest {
        filter: string;
        sem_id: string;
        sort: string;
    }
    export interface AssignmentResponse {
        assignments: Array<Assignment>;
        error: string;
        login?: boolean;
    }
}
export namespace activitypoint {
    export interface ActivityPointResponse {
        activity_points?: Array<ActivityPoints>;
        error?: string;
        login?: boolean;
        total_activity_point?: string;
    }
    export interface ActivityPoints {
        activity_name: string;
        point: string;
        semester: string;
    }
    export namespace manage {
        export interface ActivityBatch {
            activity_batch_id: string;
            activity_name: string;
            description: string;
            max_point: string;
            semester: string;
            status: string;
        }
        export interface ActivityBatchResponse {
            activity_batch?: Array<ActivityBatch>;
            error?: string;
            login?: boolean;
        }
    }
}