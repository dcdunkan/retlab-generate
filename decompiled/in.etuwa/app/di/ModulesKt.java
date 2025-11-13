package in.etuwa.app.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import in.etuwa.app.EtlabApp;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.data.network.ApiService;
import in.etuwa.app.data.network.ApiServiceImpl;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.data.repository.ActivityPointRepository;
import in.etuwa.app.data.repository.AssignmentRepository;
import in.etuwa.app.data.repository.AttendanceRepository;
import in.etuwa.app.data.repository.CertificateRequestRepository;
import in.etuwa.app.data.repository.ChangePasswordRepository;
import in.etuwa.app.data.repository.ChatRepository;
import in.etuwa.app.data.repository.CommonRepository;
import in.etuwa.app.data.repository.CounsellingRepository;
import in.etuwa.app.data.repository.CovidCertificateRepository;
import in.etuwa.app.data.repository.DashRepository;
import in.etuwa.app.data.repository.ExamRegistrationRepository;
import in.etuwa.app.data.repository.ExamRepository;
import in.etuwa.app.data.repository.FeeArtsRepository;
import in.etuwa.app.data.repository.FeeEngineerRepository;
import in.etuwa.app.data.repository.FeeRepository;
import in.etuwa.app.data.repository.GrievanceRepository;
import in.etuwa.app.data.repository.HomeWorkRepository;
import in.etuwa.app.data.repository.HostelRepository;
import in.etuwa.app.data.repository.InternshipRepository;
import in.etuwa.app.data.repository.LabRepository;
import in.etuwa.app.data.repository.LeaveRepository;
import in.etuwa.app.data.repository.LeavemanagementRepository;
import in.etuwa.app.data.repository.LibraryRepository;
import in.etuwa.app.data.repository.LoginRepository;
import in.etuwa.app.data.repository.MainRepository;
import in.etuwa.app.data.repository.MaterialRepository;
import in.etuwa.app.data.repository.MsgRepository;
import in.etuwa.app.data.repository.ProgramOutcomeRepository;
import in.etuwa.app.data.repository.QuizRepository;
import in.etuwa.app.data.repository.ResetPasswordRepository;
import in.etuwa.app.data.repository.ResultRepository;
import in.etuwa.app.data.repository.SemRegRepository;
import in.etuwa.app.data.repository.StationaryRepository;
import in.etuwa.app.data.repository.StoreRepository;
import in.etuwa.app.data.repository.SubjectRepository;
import in.etuwa.app.data.repository.SurveyRepository;
import in.etuwa.app.data.repository.TimeTableRepository;
import in.etuwa.app.data.repository.TransportRepository;
import in.etuwa.app.data.repository.TutorialRepository;
import in.etuwa.app.data.repository.VideoClassRepository;
import in.etuwa.app.helper.ListSpinnerAdapter;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.activitypoint.ActivityPointAdapter;
import in.etuwa.app.ui.activitypoint.ActivityPointViewModel;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityViewModel;
import in.etuwa.app.ui.activitypoint.manage.proofFile.ProofFileDialogViewModel;
import in.etuwa.app.ui.assignment.AssignmentAdapter;
import in.etuwa.app.ui.assignment.AssignmentViewModel;
import in.etuwa.app.ui.assignment.upload.UploadAssignmentDialogViewModel;
import in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayViewModel;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel;
import in.etuwa.app.ui.attendance.bysubject.AttendanceAdapter;
import in.etuwa.app.ui.attendance.bysubject.AttendanceViewModel;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewViewModel;
import in.etuwa.app.ui.calendar.CalendarViewModel;
import in.etuwa.app.ui.centralizedinfo.CentralizedInfoAdapter;
import in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel;
import in.etuwa.app.ui.certificate_request.CertificateRequestAdapter;
import in.etuwa.app.ui.certificate_request.CertificateRequestViewModel;
import in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialogViewModel;
import in.etuwa.app.ui.certificate_request.add_request_dialog.CertificateIsHostlerSpinnerAdapter;
import in.etuwa.app.ui.certificate_request.add_request_dialog.CertificateTypeSpinnerAdapter;
import in.etuwa.app.ui.certificate_request.add_request_dialog.CertioficateType2SpinnerAdapter;
import in.etuwa.app.ui.changepassword.ChangePasswordViewModel;
import in.etuwa.app.ui.changepassword.main.LogoutChangePasswordViewModel;
import in.etuwa.app.ui.chat.ChatAdapter;
import in.etuwa.app.ui.chat.ChatViewModel;
import in.etuwa.app.ui.chat.comment.CommentAdapter;
import in.etuwa.app.ui.chat.comment.CommentDialogViewModel;
import in.etuwa.app.ui.chat.reply.CommentReplyAdapter;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogViewModel;
import in.etuwa.app.ui.circular.CircularAdapter;
import in.etuwa.app.ui.circular.CircularViewModel;
import in.etuwa.app.ui.counselling.CounsellingAdapter;
import in.etuwa.app.ui.counselling.CounsellingViewModel;
import in.etuwa.app.ui.counselling.add.AddCounsellingViewModel;
import in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter;
import in.etuwa.app.ui.counselling.add.CounsellingTypeSpinnerAdapter;
import in.etuwa.app.ui.counselling.remind.ReminderDialogViewModel;
import in.etuwa.app.ui.counselling.review.ReviewDialogViewModel;
import in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel;
import in.etuwa.app.ui.counselling.view.actions.Actions2Adapter;
import in.etuwa.app.ui.counselling.view.actions.Actions2DialogViewModel;
import in.etuwa.app.ui.counselling.view.cellmembers.CellMember2Adapter;
import in.etuwa.app.ui.counselling.view.cellmembers.CellMember2DialogViewModel;
import in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel;
import in.etuwa.app.ui.covidcertificate.CovidCertificateListMainViewModel;
import in.etuwa.app.ui.covidcertificate.CovidCertificateTwoDialogViewModel;
import in.etuwa.app.ui.dashboard.DashboardAdapter;
import in.etuwa.app.ui.dashboard.DashboardViewModel;
import in.etuwa.app.ui.dashboard.changepic.ChangeProPicDialogViewModel;
import in.etuwa.app.ui.dashboard.dashtable.DashTableViewAdapter;
import in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel;
import in.etuwa.app.ui.dashboard.dashtable.DashTimeTableAdapter;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableAdapter;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableViewModel;
import in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanAdapter;
import in.etuwa.app.ui.dashboard.daywisetimetable.subjectplan.SubjectPlanViewModel;
import in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel;
import in.etuwa.app.ui.dashboard.missiondialog.MissionDialogViewModel;
import in.etuwa.app.ui.dashboard.visiondialog.VisionDialogViewModel;
import in.etuwa.app.ui.due.DueAdapter;
import in.etuwa.app.ui.due.DueMainViewModel;
import in.etuwa.app.ui.due.DueViewModel;
import in.etuwa.app.ui.due.duepay.DuePayAdapter;
import in.etuwa.app.ui.due.duepay.DuePayViewModel;
import in.etuwa.app.ui.exam.module.ModuleTestAdapter;
import in.etuwa.app.ui.exam.module.ModuleTestViewModel;
import in.etuwa.app.ui.exam.questions.QuestionAdapter;
import in.etuwa.app.ui.exam.questions.QuestionDialogViewModel;
import in.etuwa.app.ui.exam.series.SeriesAdapter;
import in.etuwa.app.ui.exam.series.SeriesExamViewModel;
import in.etuwa.app.ui.exam.submit.SubmitExamDialogViewModel;
import in.etuwa.app.ui.examregistration.ExamRegistrationViewModel;
import in.etuwa.app.ui.examregistration.exammain.ExamMainViewModel;
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptAdapter;
import in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter2;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectAdapter3;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewAdapter;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel;
import in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyViewModel;
import in.etuwa.app.ui.examregistration.revaluation.RevaluationAdapter;
import in.etuwa.app.ui.examregistration.revaluation.RevaluationViewModel;
import in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeAdapter;
import in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel;
import in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewAdapter;
import in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewViewModel;
import in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptAdapter;
import in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptViewModel;
import in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateAdapter;
import in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateViewModel;
import in.etuwa.app.ui.examschedules.ExamAdapter;
import in.etuwa.app.ui.examschedules.ExamViewModel;
import in.etuwa.app.ui.feemedical.FeeMedicalAdapter;
import in.etuwa.app.ui.feemedical.FeeMedicalViewModel;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsAdapter;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsSemSpinnerAdapter;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerAdapter;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailAdapter;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmViewModel;
import in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewViewModel;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialAdmissionAdapter;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialMonthlyAdapter;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel;
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter;
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditViewModel;
import in.etuwa.app.ui.feepartial.kmea.FeeListAdapter;
import in.etuwa.app.ui.feepartial.kmea.FeeListViewModel;
import in.etuwa.app.ui.feepartial.kmea.FeePartialSpinnerAdapter;
import in.etuwa.app.ui.fees.FeeMainViewModel;
import in.etuwa.app.ui.fees.gateway.GatewayViewModel;
import in.etuwa.app.ui.fees.gateway2.GatewayTwoViewModel;
import in.etuwa.app.ui.fees.payment.FeeAdapter;
import in.etuwa.app.ui.fees.payment.FeeSpinnerAdapter;
import in.etuwa.app.ui.fees.payment.FeeViewModel;
import in.etuwa.app.ui.fees.receipt.ReceiptAdapter;
import in.etuwa.app.ui.fees.receipt.ReceiptViewModel;
import in.etuwa.app.ui.fees.transport.TransportFeeAdapter;
import in.etuwa.app.ui.fees.transport.TransportFeeViewModel;
import in.etuwa.app.ui.fees.transport.receipt.TransportReceiptAdapter;
import in.etuwa.app.ui.fees.transport.receipt.TransportReceiptViewModel;
import in.etuwa.app.ui.fees.webview.WebViewViewModel;
import in.etuwa.app.ui.fees.webview.fields.FieldsViewModel;
import in.etuwa.app.ui.grievance.GrievanceAdapter;
import in.etuwa.app.ui.grievance.GrievanceViewModel;
import in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel;
import in.etuwa.app.ui.grievance.add.GrievanceTypeSpinnerAdapter;
import in.etuwa.app.ui.grievance.remind.RemindDialogViewModel;
import in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel;
import in.etuwa.app.ui.grievance.view.actions.ActionsAdapter;
import in.etuwa.app.ui.grievance.view.actions.ActionsDialogViewModel;
import in.etuwa.app.ui.grievance.view.cellmembers.CellMemberAdapter;
import in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialogViewModel;
import in.etuwa.app.ui.grievance.view.doc.GrievanceDocAdapter;
import in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialogViewModel;
import in.etuwa.app.ui.homework.HomeWorkAdapter;
import in.etuwa.app.ui.homework.HomeWorkViewModel;
import in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter;
import in.etuwa.app.ui.homework.files.HomeWorkFilesDialogViewModel;
import in.etuwa.app.ui.homework.submit.SubmitHomeWorkDialogViewModel;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceViewModel;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelLeaveTypeSpinnerAdapter;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentAdapter;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveViewModel;
import in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationViewModel;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.ReAdmissionSpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.DefaulterSpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.FineSpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.NoOfYearSpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.PresentHostelSpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel;
import in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel;
import in.etuwa.app.ui.hostel.mess.MessAdapter;
import in.etuwa.app.ui.hostel.mess.MessViewModel;
import in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel;
import in.etuwa.app.ui.hostel.mess.booknow.MessMenuSpinnerAdapter;
import in.etuwa.app.ui.hostel.mess.booknow.MessTypeSpinnerAdapter;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryViewModel;
import in.etuwa.app.ui.hostel.mits.MitsHostelViewModel;
import in.etuwa.app.ui.hostel.palaihostel.HostelPalaiSpinnerAdapter;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdapter;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelAdmissionAdapter;
import in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel;
import in.etuwa.app.ui.hostel.palaihostel.confirmpage.PalaiHostelFeeConfirmViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.HostelMainViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.fee.HostelMonthAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeesAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.kmeahostel.KmeaHostelViewModel;
import in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptAdapter;
import in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel;
import in.etuwa.app.ui.hostelnew.HostelNewAdmissionAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistory2Adapter;
import in.etuwa.app.ui.hostelnew.HostelNewHistoryAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewMonthlyAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewReceiptAdapter;
import in.etuwa.app.ui.hostelnew.HostelNewViewModel;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmViewModel;
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsAdapter;
import in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel;
import in.etuwa.app.ui.internship.InternshipAdapter;
import in.etuwa.app.ui.internship.InternshipViewModel;
import in.etuwa.app.ui.internship.apply.ApplyInternshipViewModel;
import in.etuwa.app.ui.internship.apply.InternshipCompanySpinnerAdapter;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyViewModel;
import in.etuwa.app.ui.internship.completioncertificate.CompletionCertificateDialogViewModel;
import in.etuwa.app.ui.lab.LabViewModel;
import in.etuwa.app.ui.lab.equipment.LabListAdapter;
import in.etuwa.app.ui.lab.equipment.LabListViewModel;
import in.etuwa.app.ui.lab.equipment.labequipments.EquipmentAdapter;
import in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel;
import in.etuwa.app.ui.lab.equipment.labsafety.SafetyAdapter;
import in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel;
import in.etuwa.app.ui.lab.labdue.LabDueAdapter;
import in.etuwa.app.ui.lab.labdue.LabDueViewModel;
import in.etuwa.app.ui.lab.practical.LabPracticalAdapter;
import in.etuwa.app.ui.lab.practical.LabPracticalViewModel;
import in.etuwa.app.ui.lab.practical.evaluation.EvaluationAdapter;
import in.etuwa.app.ui.lab.practical.evaluation.EvaluationViewModel;
import in.etuwa.app.ui.lab.practical.experiment.ExperimentAdapter;
import in.etuwa.app.ui.lab.practical.experiment.ExperimentViewModel;
import in.etuwa.app.ui.leave.LeaveAdapter;
import in.etuwa.app.ui.leave.LeaveViewModel;
import in.etuwa.app.ui.leave.duty.DutyLeaveAdapter;
import in.etuwa.app.ui.leave.duty.DutyLeaveViewModel;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyAdapter;
import in.etuwa.app.ui.leave.duty.directapply.DirectApplyViewModel;
import in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveViewModel;
import in.etuwa.app.ui.leave.duty.directapply.apply.DutyHeadSpinnerAdapter;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.DateAdapter;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.HourAdapter;
import in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel;
import in.etuwa.app.ui.leave.duty.directapply.viewproof.ViewProofViewModel;
import in.etuwa.app.ui.leave.duty.proof.ProofDutyLeaveAdapter;
import in.etuwa.app.ui.leave.duty.proof.ProofDutyLeaveViewModel;
import in.etuwa.app.ui.leave.duty.proof.ViewProofDutyLeaveViewModel;
import in.etuwa.app.ui.leave.medical.MedicalAdapter;
import in.etuwa.app.ui.leave.medical.MedicalViewModel;
import in.etuwa.app.ui.leave.medical.add.AddMedicalLeaveViewModel;
import in.etuwa.app.ui.leavemanagement.LeaveManagementAdapter;
import in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel;
import in.etuwa.app.ui.library.book.BookAdapter;
import in.etuwa.app.ui.library.book.BookViewModel;
import in.etuwa.app.ui.library.book.details.BookDetailsViewModel;
import in.etuwa.app.ui.library.suggest.SuggestBookViewModel;
import in.etuwa.app.ui.live.LiveTvAdapter;
import in.etuwa.app.ui.live.LiveTvViewModel;
import in.etuwa.app.ui.login.CollegeListAdapter;
import in.etuwa.app.ui.login.CollegeSpinnerAdapter;
import in.etuwa.app.ui.login.LoginViewModel;
import in.etuwa.app.ui.main.MainViewModel;
import in.etuwa.app.ui.message.inbox.InboxAdapter;
import in.etuwa.app.ui.message.inbox.MessageViewModel;
import in.etuwa.app.ui.message.reply.ReplyViewModel;
import in.etuwa.app.ui.message.sentItems.SentItemAdapter;
import in.etuwa.app.ui.message.sentItems.SentItemViewModel;
import in.etuwa.app.ui.newquiz.NewQuizAdapter;
import in.etuwa.app.ui.newquiz.NewQuizViewModel;
import in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel;
import in.etuwa.app.ui.newquiz.viewresult.QuizDescriptiveResultAdapter;
import in.etuwa.app.ui.newquiz.viewresult.QuizMultipleResultAdapter;
import in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel;
import in.etuwa.app.ui.newquiz.viewresult.QuizUploadResultAdapter;
import in.etuwa.app.ui.notice.NoticeAdapter;
import in.etuwa.app.ui.notice.NoticeMainAdapter;
import in.etuwa.app.ui.notice.NoticeViewModel;
import in.etuwa.app.ui.onlineclass.OnlineClassAdapter;
import in.etuwa.app.ui.onlineclass.OnlineClassViewModel;
import in.etuwa.app.ui.placement.PlacementAdapter;
import in.etuwa.app.ui.placement.PlacementViewModel;
import in.etuwa.app.ui.profile.ProfileViewModel;
import in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankViewModel;
import in.etuwa.app.ui.profile.bankdetails.BankDetailsViewModel;
import in.etuwa.app.ui.profile.contactdetails.ContactDetailsViewModel;
import in.etuwa.app.ui.profile.parentdetails.ParentDetailsViewModel;
import in.etuwa.app.ui.profile.personaldetails.PersonalDetailsViewModel;
import in.etuwa.app.ui.profile.updateabc.UpdateAbcViewModel;
import in.etuwa.app.ui.profile.updateprofile.UpdateProfileViewModel;
import in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel;
import in.etuwa.app.ui.programoutcome.adapters.ProgramEducationalAdapter;
import in.etuwa.app.ui.programoutcome.adapters.ProgramOutcomeAdapter;
import in.etuwa.app.ui.programoutcome.adapters.ProgramSpecificAdapter;
import in.etuwa.app.ui.programoutcome.main.ProgramOutcomeMainViewModel;
import in.etuwa.app.ui.push.PushAdapter;
import in.etuwa.app.ui.questionbank.QuestionBankAdapter;
import in.etuwa.app.ui.questionbank.QuestionBankViewModel;
import in.etuwa.app.ui.registration.RegistrationViewModel;
import in.etuwa.app.ui.remark.RemarkAdapter;
import in.etuwa.app.ui.remark.RemarkViewModel;
import in.etuwa.app.ui.resetpassword.ResetPasswordViewModel;
import in.etuwa.app.ui.result.ResultAdapter;
import in.etuwa.app.ui.result.ResultViewModel;
import in.etuwa.app.ui.result.assignment.AssignmentResultAdapter;
import in.etuwa.app.ui.result.assignment.AssignmentResultViewModel;
import in.etuwa.app.ui.result.internal.InternalResultAdapter;
import in.etuwa.app.ui.result.internal.InternalResultViewModel;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestAdapter;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestViewModel;
import in.etuwa.app.ui.result.session.SessionalAdapter;
import in.etuwa.app.ui.result.session.SessionalViewModel;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListAdapterTwo;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogViewModelTwo;
import in.etuwa.app.ui.result.tutorials.TutorialResultAdapter;
import in.etuwa.app.ui.result.tutorials.TutorialResultViewModel;
import in.etuwa.app.ui.result.university.UniversityViewModel;
import in.etuwa.app.ui.result.university.exampages.UniversityExamAdapter;
import in.etuwa.app.ui.result.university.exampages.UniversityExamsViewModel;
import in.etuwa.app.ui.result.university.initialpage.UnivInitialPageAdapter;
import in.etuwa.app.ui.result.university.initialpage.UnivInitialPageViewModel;
import in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter;
import in.etuwa.app.ui.result.university.semlistdialog.SemListDialogViewModel;
import in.etuwa.app.ui.semregistration.asiet.semreg.AsietSemRegViewModel;
import in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel;
import in.etuwa.app.ui.semregistration.edit.SemRegViewModel;
import in.etuwa.app.ui.semregistration.list.SemRegisterListAdapter;
import in.etuwa.app.ui.semregistration.list.SemRegisterListViewModel;
import in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter;
import in.etuwa.app.ui.semregistration.mace.MaceNewSemRegViewModel;
import in.etuwa.app.ui.semregistration.mace.SemesterRegistrationSpinnerAdapter;
import in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel;
import in.etuwa.app.ui.semregistration.mvjce.CurrentSemSpinnerAdapter;
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel;
import in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegAdapter;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegViewModel;
import in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel;
import in.etuwa.app.ui.semregistration.view.SemRegViewViewModel;
import in.etuwa.app.ui.stationary.StationaryMainAdapter;
import in.etuwa.app.ui.stationary.StationaryMainViewModel;
import in.etuwa.app.ui.stationary.booking.BookingAdapter;
import in.etuwa.app.ui.stationary.booking.BookingViewModel;
import in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel;
import in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryAdapter;
import in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel;
import in.etuwa.app.ui.store.StoreDialogViewModel;
import in.etuwa.app.ui.store.adapters.StoreDepartmentAdapter;
import in.etuwa.app.ui.store.adapters.StoreSemesterAdapter;
import in.etuwa.app.ui.store.adapters.StoreSubjectAdapter;
import in.etuwa.app.ui.store.storeview.StoreAdapter;
import in.etuwa.app.ui.store.storeview.StoreCategoryAdapter;
import in.etuwa.app.ui.store.storeview.StoreViewModel;
import in.etuwa.app.ui.studymaterials.MaterialAdapter;
import in.etuwa.app.ui.studymaterials.MaterialFilterAdapter;
import in.etuwa.app.ui.studymaterials.MaterialModuleAdapter;
import in.etuwa.app.ui.studymaterials.MaterialViewModel;
import in.etuwa.app.ui.studymaterials.download.MaterialDownloadAdapter;
import in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel;
import in.etuwa.app.ui.subject.SubjectAdapter;
import in.etuwa.app.ui.subject.SubjectViewModel;
import in.etuwa.app.ui.subject.co.CoAdapter;
import in.etuwa.app.ui.subject.co.CoViewModel;
import in.etuwa.app.ui.subject.coverage.SubjectCoverageAdapter;
import in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel;
import in.etuwa.app.ui.subject.syllabus.SyllabusAdapter;
import in.etuwa.app.ui.subject.syllabus.SyllabusViewModel;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationAdapter;
import in.etuwa.app.ui.subjectregistration.SubjectRegistrationViewModel;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationSpinnerAdapter;
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationViewModel;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegViewModel;
import in.etuwa.app.ui.subjectregistration.applywithpreference.PathwaySpinnerAdapter;
import in.etuwa.app.ui.subjectregistration.applywithpreference.SubjectRegSpinnerAdapter;
import in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusAdapter;
import in.etuwa.app.ui.subjectregistration.statusview.SubjectRegStatusViewModel;
import in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel;
import in.etuwa.app.ui.survey.SurveyAdapter;
import in.etuwa.app.ui.survey.SurveyViewModel;
import in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyAdapter;
import in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyViewModel;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsAdapter;
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsViewModel;
import in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsAdapter;
import in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel;
import in.etuwa.app.ui.survey.graduateexit.GraduateExitSurveyAdapter;
import in.etuwa.app.ui.survey.graduateexit.GraduateExitSurveyViewModel;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsAdapter;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel;
import in.etuwa.app.ui.survey.posurvey.POSurveyAdapter;
import in.etuwa.app.ui.survey.posurvey.POSurveyViewModel;
import in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsAdapter;
import in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel;
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter;
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewViewModel;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter;
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionViewModel;
import in.etuwa.app.ui.teacher.TeacherAdapter;
import in.etuwa.app.ui.teacher.TeacherViewModel;
import in.etuwa.app.ui.timetable.TimeTableAdapter;
import in.etuwa.app.ui.timetable.TimeTableViewModel;
import in.etuwa.app.ui.timetable.change.ChangeInTimetableAdapter;
import in.etuwa.app.ui.timetable.change.ChangeInTimetableViewModel;
import in.etuwa.app.ui.timetable.special.SpecialClassAdapter;
import in.etuwa.app.ui.timetable.special.SpecialClassViewModel;
import in.etuwa.app.ui.timetable.tableview.TimetableViewAdapter;
import in.etuwa.app.ui.timetable.tableview.TimetableViewViewModel;
import in.etuwa.app.ui.transport.buspass.BusPassViewModel;
import in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenViewModel;
import in.etuwa.app.ui.transport.history.TransportHistoryAdapter;
import in.etuwa.app.ui.transport.history.TransportHistoryViewModel;
import in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegAdapter;
import in.etuwa.app.ui.transport.registration.asiet.registerview.AsietTransRegViewModel;
import in.etuwa.app.ui.transport.registration.asiet.registration.AsietBoardingSpinnerAdapter;
import in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter;
import in.etuwa.app.ui.transport.registration.register.TransportRegistrationViewModel;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryAdapter;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryViewModel;
import in.etuwa.app.ui.tutorial.TutorialAdapter;
import in.etuwa.app.ui.tutorial.TutorialViewModel;
import in.etuwa.app.ui.tutorial.upload.UploadTutorialDialogViewModel;
import in.etuwa.app.ui.university.UniversityResultAdapter;
import in.etuwa.app.ui.university.UniversityResultViewModel;
import in.etuwa.app.ui.videoclass.VideoClassAdapter;
import in.etuwa.app.ui.videoclass.VideoClassViewModel;
import in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordAdapter;
import in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: Modules.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"AdapterModule", "Lorg/koin/core/module/Module;", "getAdapterModule", "()Lorg/koin/core/module/Module;", "DataModule", "getDataModule", "FactoryModule", "getFactoryModule", "NetworkModule", "getNetworkModule", "ViewModelModule", "getViewModelModule", "appModules", "", "getAppModules", "()Ljava/util/List;", "app_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModulesKt {
    private static final Module AdapterModule;
    private static final Module DataModule;
    private static final Module FactoryModule;
    private static final Module NetworkModule;
    private static final Module ViewModelModule;
    private static final List<Module> appModules;

    static {
        Module module$default = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: in.etuwa.app.di.ModulesKt$DataModule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, SharedPrefManager>() { // from class: in.etuwa.app.di.ModulesKt$DataModule$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final SharedPrefManager invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SharedPrefManager(EtlabApp.INSTANCE.get());
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SharedPrefManager.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory);
                }
                new Pair(module, singleInstanceFactory);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, MyDataBase>() { // from class: in.etuwa.app.di.ModulesKt$DataModule$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final MyDataBase invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MyDataBase(EtlabApp.INSTANCE.get());
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MyDataBase.class), null, anonymousClass2, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory2);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory2);
                }
                new Pair(module, singleInstanceFactory2);
            }
        }, 1, null);
        DataModule = module$default;
        Module module$default2 = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: in.etuwa.app.di.ModulesKt$NetworkModule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, ApiService>() { // from class: in.etuwa.app.di.ModulesKt$NetworkModule$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final ApiService invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApiServiceImpl();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApiService.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory);
                new Pair(module, factoryInstanceFactory);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, ApiHelper>() { // from class: in.etuwa.app.di.ModulesKt$NetworkModule$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final ApiHelper invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApiHelper((ApiService) factory.get(Reflection.getOrCreateKotlinClass(ApiService.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApiHelper.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory2);
                new Pair(module, factoryInstanceFactory2);
            }
        }, 1, null);
        NetworkModule = module$default2;
        Module module$default3 = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, CommonRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final CommonRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CommonRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CommonRepository.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory);
                new Pair(module, factoryInstanceFactory);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, LoginRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final LoginRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LoginRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LoginRepository.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory2);
                new Pair(module, factoryInstanceFactory2);
                AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, MainRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.3
                    @Override // kotlin.jvm.functions.Function2
                    public final MainRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MainRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MainRepository.class), null, anonymousClass3, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory3);
                new Pair(module, factoryInstanceFactory3);
                AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, MsgRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.4
                    @Override // kotlin.jvm.functions.Function2
                    public final MsgRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MsgRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MsgRepository.class), null, anonymousClass4, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory4);
                new Pair(module, factoryInstanceFactory4);
                AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, DashRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.5
                    @Override // kotlin.jvm.functions.Function2
                    public final DashRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DashRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashRepository.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory5);
                new Pair(module, factoryInstanceFactory5);
                AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, TimeTableRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.6
                    @Override // kotlin.jvm.functions.Function2
                    public final TimeTableRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TimeTableRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimeTableRepository.class), null, anonymousClass6, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory6);
                new Pair(module, factoryInstanceFactory6);
                AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, SubjectRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.7
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRepository.class), null, anonymousClass7, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory7);
                new Pair(module, factoryInstanceFactory7);
                AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, VideoClassRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.8
                    @Override // kotlin.jvm.functions.Function2
                    public final VideoClassRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new VideoClassRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VideoClassRepository.class), null, anonymousClass8, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory8);
                new Pair(module, factoryInstanceFactory8);
                AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, AttendanceRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.9
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, anonymousClass9, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory9);
                new Pair(module, factoryInstanceFactory9);
                AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, LabRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.10
                    @Override // kotlin.jvm.functions.Function2
                    public final LabRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabRepository.class), null, anonymousClass10, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory10);
                new Pair(module, factoryInstanceFactory10);
                AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, ChatRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.11
                    @Override // kotlin.jvm.functions.Function2
                    public final ChatRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChatRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatRepository.class), null, anonymousClass11, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory11);
                new Pair(module, factoryInstanceFactory11);
                AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, SurveyRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.12
                    @Override // kotlin.jvm.functions.Function2
                    public final SurveyRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SurveyRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, anonymousClass12, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory12);
                new Pair(module, factoryInstanceFactory12);
                AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, ResultRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.13
                    @Override // kotlin.jvm.functions.Function2
                    public final ResultRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResultRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResultRepository.class), null, anonymousClass13, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory13);
                new Pair(module, factoryInstanceFactory13);
                AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, LeaveRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.14
                    @Override // kotlin.jvm.functions.Function2
                    public final LeaveRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LeaveRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, anonymousClass14, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory14);
                new Pair(module, factoryInstanceFactory14);
                AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, MaterialRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.15
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaterialRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialRepository.class), null, anonymousClass15, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory15);
                new Pair(module, factoryInstanceFactory15);
                AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, ExamRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.16
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamRepository.class), null, anonymousClass16, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory16);
                new Pair(module, factoryInstanceFactory16);
                AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, AssignmentRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.17
                    @Override // kotlin.jvm.functions.Function2
                    public final AssignmentRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AssignmentRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AssignmentRepository.class), null, anonymousClass17, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory17);
                new Pair(module, factoryInstanceFactory17);
                AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, QuizRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.18
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizRepository.class), null, anonymousClass18, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory18);
                new Pair(module, factoryInstanceFactory18);
                AnonymousClass19 anonymousClass19 = new Function2<Scope, ParametersHolder, SemRegRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.19
                    @Override // kotlin.jvm.functions.Function2
                    public final SemRegRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemRegRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory19 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, anonymousClass19, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory19);
                new Pair(module, factoryInstanceFactory19);
                AnonymousClass20 anonymousClass20 = new Function2<Scope, ParametersHolder, TutorialRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.20
                    @Override // kotlin.jvm.functions.Function2
                    public final TutorialRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TutorialRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory20 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialRepository.class), null, anonymousClass20, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory20);
                new Pair(module, factoryInstanceFactory20);
                AnonymousClass21 anonymousClass21 = new Function2<Scope, ParametersHolder, HomeWorkRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.21
                    @Override // kotlin.jvm.functions.Function2
                    public final HomeWorkRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HomeWorkRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory21 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeWorkRepository.class), null, anonymousClass21, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory21);
                new Pair(module, factoryInstanceFactory21);
                AnonymousClass22 anonymousClass22 = new Function2<Scope, ParametersHolder, FeeRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.22
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory22 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeRepository.class), null, anonymousClass22, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory22);
                new Pair(module, factoryInstanceFactory22);
                AnonymousClass23 anonymousClass23 = new Function2<Scope, ParametersHolder, ActivityPointRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.23
                    @Override // kotlin.jvm.functions.Function2
                    public final ActivityPointRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ActivityPointRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory23 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ActivityPointRepository.class), null, anonymousClass23, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory23);
                new Pair(module, factoryInstanceFactory23);
                AnonymousClass24 anonymousClass24 = new Function2<Scope, ParametersHolder, GrievanceRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.24
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GrievanceRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory24 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceRepository.class), null, anonymousClass24, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory24);
                new Pair(module, factoryInstanceFactory24);
                AnonymousClass25 anonymousClass25 = new Function2<Scope, ParametersHolder, CertificateRequestRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.25
                    @Override // kotlin.jvm.functions.Function2
                    public final CertificateRequestRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CertificateRequestRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory25 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertificateRequestRepository.class), null, anonymousClass25, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory25);
                new Pair(module, factoryInstanceFactory25);
                AnonymousClass26 anonymousClass26 = new Function2<Scope, ParametersHolder, CovidCertificateRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.26
                    @Override // kotlin.jvm.functions.Function2
                    public final CovidCertificateRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CovidCertificateRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory26 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CovidCertificateRepository.class), null, anonymousClass26, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory26);
                new Pair(module, factoryInstanceFactory26);
                AnonymousClass27 anonymousClass27 = new Function2<Scope, ParametersHolder, ResetPasswordRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.27
                    @Override // kotlin.jvm.functions.Function2
                    public final ResetPasswordRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResetPasswordRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory27 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResetPasswordRepository.class), null, anonymousClass27, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory27);
                new Pair(module, factoryInstanceFactory27);
                AnonymousClass28 anonymousClass28 = new Function2<Scope, ParametersHolder, CounsellingRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.28
                    @Override // kotlin.jvm.functions.Function2
                    public final CounsellingRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CounsellingRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory28 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, anonymousClass28, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory28);
                new Pair(module, factoryInstanceFactory28);
                AnonymousClass29 anonymousClass29 = new Function2<Scope, ParametersHolder, InternshipRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.29
                    @Override // kotlin.jvm.functions.Function2
                    public final InternshipRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InternshipRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory29 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternshipRepository.class), null, anonymousClass29, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory29);
                new Pair(module, factoryInstanceFactory29);
                AnonymousClass30 anonymousClass30 = new Function2<Scope, ParametersHolder, StoreRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.30
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StoreRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory30 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreRepository.class), null, anonymousClass30, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory30);
                new Pair(module, factoryInstanceFactory30);
                AnonymousClass31 anonymousClass31 = new Function2<Scope, ParametersHolder, HostelRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.31
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory31 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelRepository.class), null, anonymousClass31, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory31);
                new Pair(module, factoryInstanceFactory31);
                AnonymousClass32 anonymousClass32 = new Function2<Scope, ParametersHolder, FeeEngineerRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.32
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeEngineerRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeEngineerRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory32 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeEngineerRepository.class), null, anonymousClass32, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory32);
                new Pair(module, factoryInstanceFactory32);
                AnonymousClass33 anonymousClass33 = new Function2<Scope, ParametersHolder, FeeArtsRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.33
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeArtsRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeArtsRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory33 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeArtsRepository.class), null, anonymousClass33, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory33);
                new Pair(module, factoryInstanceFactory33);
                AnonymousClass34 anonymousClass34 = new Function2<Scope, ParametersHolder, ProgramOutcomeRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.34
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramOutcomeRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramOutcomeRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory34 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramOutcomeRepository.class), null, anonymousClass34, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory34);
                new Pair(module, factoryInstanceFactory34);
                AnonymousClass35 anonymousClass35 = new Function2<Scope, ParametersHolder, LeavemanagementRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.35
                    @Override // kotlin.jvm.functions.Function2
                    public final LeavemanagementRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LeavemanagementRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory35 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeavemanagementRepository.class), null, anonymousClass35, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory35);
                new Pair(module, factoryInstanceFactory35);
                AnonymousClass36 anonymousClass36 = new Function2<Scope, ParametersHolder, ChangePasswordRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.36
                    @Override // kotlin.jvm.functions.Function2
                    public final ChangePasswordRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChangePasswordRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory36 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChangePasswordRepository.class), null, anonymousClass36, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory36);
                new Pair(module, factoryInstanceFactory36);
                AnonymousClass37 anonymousClass37 = new Function2<Scope, ParametersHolder, ExamRegistrationRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.37
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamRegistrationRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamRegistrationRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory37 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, anonymousClass37, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory37);
                new Pair(module, factoryInstanceFactory37);
                AnonymousClass38 anonymousClass38 = new Function2<Scope, ParametersHolder, LibraryRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.38
                    @Override // kotlin.jvm.functions.Function2
                    public final LibraryRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LibraryRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory38 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LibraryRepository.class), null, anonymousClass38, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory38);
                new Pair(module, factoryInstanceFactory38);
                AnonymousClass39 anonymousClass39 = new Function2<Scope, ParametersHolder, TransportRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.39
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory39 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportRepository.class), null, anonymousClass39, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory39);
                new Pair(module, factoryInstanceFactory39);
                AnonymousClass40 anonymousClass40 = new Function2<Scope, ParametersHolder, StationaryRepository>() { // from class: in.etuwa.app.di.ModulesKt$FactoryModule$1.40
                    @Override // kotlin.jvm.functions.Function2
                    public final StationaryRepository invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StationaryRepository((ApiHelper) factory.get(Reflection.getOrCreateKotlinClass(ApiHelper.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory40 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StationaryRepository.class), null, anonymousClass40, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory40);
                new Pair(module, factoryInstanceFactory40);
            }
        }, 1, null);
        FactoryModule = module$default3;
        Module module$default4 = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, LoginViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final LoginViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LoginViewModel((LoginRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LoginRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LoginViewModel.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory);
                new Pair(module, factoryInstanceFactory);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, MainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final MainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MainViewModel((MainRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MainRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MainViewModel.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory2);
                new Pair(module, factoryInstanceFactory2);
                AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, RegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.3
                    @Override // kotlin.jvm.functions.Function2
                    public final RegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RegistrationViewModel((LoginRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LoginRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RegistrationViewModel.class), null, anonymousClass3, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory3);
                new Pair(module, factoryInstanceFactory3);
                AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, CalendarViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.4
                    @Override // kotlin.jvm.functions.Function2
                    public final CalendarViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CalendarViewModel((MainRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MainRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CalendarViewModel.class), null, anonymousClass4, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory4);
                new Pair(module, factoryInstanceFactory4);
                AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, MessageViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.5
                    @Override // kotlin.jvm.functions.Function2
                    public final MessageViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MessageViewModel((MsgRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MsgRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessageViewModel.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory5);
                new Pair(module, factoryInstanceFactory5);
                AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, ReplyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.6
                    @Override // kotlin.jvm.functions.Function2
                    public final ReplyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReplyViewModel((MsgRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MsgRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReplyViewModel.class), null, anonymousClass6, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory6);
                new Pair(module, factoryInstanceFactory6);
                AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, SentItemViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.7
                    @Override // kotlin.jvm.functions.Function2
                    public final SentItemViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SentItemViewModel((MsgRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MsgRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SentItemViewModel.class), null, anonymousClass7, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory7);
                new Pair(module, factoryInstanceFactory7);
                AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, DashboardViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.8
                    @Override // kotlin.jvm.functions.Function2
                    public final DashboardViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DashboardViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashboardViewModel.class), null, anonymousClass8, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory8);
                new Pair(module, factoryInstanceFactory8);
                AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, ChangeProPicDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.9
                    @Override // kotlin.jvm.functions.Function2
                    public final ChangeProPicDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChangeProPicDialogViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChangeProPicDialogViewModel.class), null, anonymousClass9, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory9);
                new Pair(module, factoryInstanceFactory9);
                AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, ProfileViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.10
                    @Override // kotlin.jvm.functions.Function2
                    public final ProfileViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProfileViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProfileViewModel.class), null, anonymousClass10, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory10);
                new Pair(module, factoryInstanceFactory10);
                AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, DashTableViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.11
                    @Override // kotlin.jvm.functions.Function2
                    public final DashTableViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DashTableViewViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashTableViewViewModel.class), null, anonymousClass11, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory11);
                new Pair(module, factoryInstanceFactory11);
                AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, TimeTableViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.12
                    @Override // kotlin.jvm.functions.Function2
                    public final TimeTableViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TimeTableViewModel((TimeTableRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TimeTableRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimeTableViewModel.class), null, anonymousClass12, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory12);
                new Pair(module, factoryInstanceFactory12);
                AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, TimetableViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.13
                    @Override // kotlin.jvm.functions.Function2
                    public final TimetableViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TimetableViewViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimetableViewViewModel.class), null, anonymousClass13, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory13);
                new Pair(module, factoryInstanceFactory13);
                AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, ChangeInTimetableViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.14
                    @Override // kotlin.jvm.functions.Function2
                    public final ChangeInTimetableViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChangeInTimetableViewModel((TimeTableRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TimeTableRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChangeInTimetableViewModel.class), null, anonymousClass14, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory14);
                new Pair(module, factoryInstanceFactory14);
                AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, SpecialClassViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.15
                    @Override // kotlin.jvm.functions.Function2
                    public final SpecialClassViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SpecialClassViewModel((TimeTableRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TimeTableRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SpecialClassViewModel.class), null, anonymousClass15, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory15);
                new Pair(module, factoryInstanceFactory15);
                AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, NoticeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.16
                    @Override // kotlin.jvm.functions.Function2
                    public final NoticeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NoticeViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NoticeViewModel.class), null, anonymousClass16, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory16);
                new Pair(module, factoryInstanceFactory16);
                AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, RemarkViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.17
                    @Override // kotlin.jvm.functions.Function2
                    public final RemarkViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RemarkViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RemarkViewModel.class), null, anonymousClass17, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory17);
                new Pair(module, factoryInstanceFactory17);
                AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, ExamViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.18
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamViewModel.class), null, anonymousClass18, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory18);
                new Pair(module, factoryInstanceFactory18);
                AnonymousClass19 anonymousClass19 = new Function2<Scope, ParametersHolder, CircularViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.19
                    @Override // kotlin.jvm.functions.Function2
                    public final CircularViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CircularViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory19 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CircularViewModel.class), null, anonymousClass19, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory19);
                new Pair(module, factoryInstanceFactory19);
                AnonymousClass20 anonymousClass20 = new Function2<Scope, ParametersHolder, PlacementViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.20
                    @Override // kotlin.jvm.functions.Function2
                    public final PlacementViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PlacementViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory20 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PlacementViewModel.class), null, anonymousClass20, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory20);
                new Pair(module, factoryInstanceFactory20);
                AnonymousClass21 anonymousClass21 = new Function2<Scope, ParametersHolder, TeacherViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.21
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory21 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherViewModel.class), null, anonymousClass21, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory21);
                new Pair(module, factoryInstanceFactory21);
                AnonymousClass22 anonymousClass22 = new Function2<Scope, ParametersHolder, CentralizedInfoViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.22
                    @Override // kotlin.jvm.functions.Function2
                    public final CentralizedInfoViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CentralizedInfoViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory22 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CentralizedInfoViewModel.class), null, anonymousClass22, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory22);
                new Pair(module, factoryInstanceFactory22);
                AnonymousClass23 anonymousClass23 = new Function2<Scope, ParametersHolder, LiveTvViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.23
                    @Override // kotlin.jvm.functions.Function2
                    public final LiveTvViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LiveTvViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory23 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LiveTvViewModel.class), null, anonymousClass23, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory23);
                new Pair(module, factoryInstanceFactory23);
                AnonymousClass24 anonymousClass24 = new Function2<Scope, ParametersHolder, DueViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.24
                    @Override // kotlin.jvm.functions.Function2
                    public final DueViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DueViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory24 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DueViewModel.class), null, anonymousClass24, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory24);
                new Pair(module, factoryInstanceFactory24);
                AnonymousClass25 anonymousClass25 = new Function2<Scope, ParametersHolder, DuePayViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.25
                    @Override // kotlin.jvm.functions.Function2
                    public final DuePayViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DuePayViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory25 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DuePayViewModel.class), null, anonymousClass25, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory25);
                new Pair(module, factoryInstanceFactory25);
                AnonymousClass26 anonymousClass26 = new Function2<Scope, ParametersHolder, SubjectViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.26
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectViewModel((SubjectRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SubjectRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory26 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectViewModel.class), null, anonymousClass26, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory26);
                new Pair(module, factoryInstanceFactory26);
                AnonymousClass27 anonymousClass27 = new Function2<Scope, ParametersHolder, SyllabusViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.27
                    @Override // kotlin.jvm.functions.Function2
                    public final SyllabusViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SyllabusViewModel((SubjectRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SubjectRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory27 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SyllabusViewModel.class), null, anonymousClass27, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory27);
                new Pair(module, factoryInstanceFactory27);
                AnonymousClass28 anonymousClass28 = new Function2<Scope, ParametersHolder, CoViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.28
                    @Override // kotlin.jvm.functions.Function2
                    public final CoViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CoViewModel((SubjectRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SubjectRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory28 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CoViewModel.class), null, anonymousClass28, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory28);
                new Pair(module, factoryInstanceFactory28);
                AnonymousClass29 anonymousClass29 = new Function2<Scope, ParametersHolder, SubjectCoverageViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.29
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectCoverageViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectCoverageViewModel((SubjectRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SubjectRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory29 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectCoverageViewModel.class), null, anonymousClass29, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory29);
                new Pair(module, factoryInstanceFactory29);
                AnonymousClass30 anonymousClass30 = new Function2<Scope, ParametersHolder, OnlineClassViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.30
                    @Override // kotlin.jvm.functions.Function2
                    public final OnlineClassViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OnlineClassViewModel((VideoClassRepository) viewModel.get(Reflection.getOrCreateKotlinClass(VideoClassRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory30 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OnlineClassViewModel.class), null, anonymousClass30, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory30);
                new Pair(module, factoryInstanceFactory30);
                AnonymousClass31 anonymousClass31 = new Function2<Scope, ParametersHolder, VideoClassViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.31
                    @Override // kotlin.jvm.functions.Function2
                    public final VideoClassViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new VideoClassViewModel((VideoClassRepository) viewModel.get(Reflection.getOrCreateKotlinClass(VideoClassRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory31 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VideoClassViewModel.class), null, anonymousClass31, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory31);
                new Pair(module, factoryInstanceFactory31);
                AnonymousClass32 anonymousClass32 = new Function2<Scope, ParametersHolder, AttendanceViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.32
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceViewModel((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory32 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceViewModel.class), null, anonymousClass32, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory32);
                new Pair(module, factoryInstanceFactory32);
                AnonymousClass33 anonymousClass33 = new Function2<Scope, ParametersHolder, LabDueViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.33
                    @Override // kotlin.jvm.functions.Function2
                    public final LabDueViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabDueViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory33 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabDueViewModel.class), null, anonymousClass33, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory33);
                new Pair(module, factoryInstanceFactory33);
                AnonymousClass34 anonymousClass34 = new Function2<Scope, ParametersHolder, LabListViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.34
                    @Override // kotlin.jvm.functions.Function2
                    public final LabListViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabListViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory34 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabListViewModel.class), null, anonymousClass34, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory34);
                new Pair(module, factoryInstanceFactory34);
                AnonymousClass35 anonymousClass35 = new Function2<Scope, ParametersHolder, EquipmentViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.35
                    @Override // kotlin.jvm.functions.Function2
                    public final EquipmentViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new EquipmentViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory35 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EquipmentViewModel.class), null, anonymousClass35, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory35);
                new Pair(module, factoryInstanceFactory35);
                AnonymousClass36 anonymousClass36 = new Function2<Scope, ParametersHolder, SafetyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.36
                    @Override // kotlin.jvm.functions.Function2
                    public final SafetyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SafetyViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory36 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SafetyViewModel.class), null, anonymousClass36, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory36);
                new Pair(module, factoryInstanceFactory36);
                AnonymousClass37 anonymousClass37 = new Function2<Scope, ParametersHolder, LabPracticalViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.37
                    @Override // kotlin.jvm.functions.Function2
                    public final LabPracticalViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabPracticalViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory37 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabPracticalViewModel.class), null, anonymousClass37, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory37);
                new Pair(module, factoryInstanceFactory37);
                AnonymousClass38 anonymousClass38 = new Function2<Scope, ParametersHolder, ExperimentViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.38
                    @Override // kotlin.jvm.functions.Function2
                    public final ExperimentViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExperimentViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory38 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExperimentViewModel.class), null, anonymousClass38, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory38);
                new Pair(module, factoryInstanceFactory38);
                AnonymousClass39 anonymousClass39 = new Function2<Scope, ParametersHolder, EvaluationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.39
                    @Override // kotlin.jvm.functions.Function2
                    public final EvaluationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new EvaluationViewModel((LabRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LabRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory39 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EvaluationViewModel.class), null, anonymousClass39, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory39);
                new Pair(module, factoryInstanceFactory39);
                AnonymousClass40 anonymousClass40 = new Function2<Scope, ParametersHolder, ChatViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.40
                    @Override // kotlin.jvm.functions.Function2
                    public final ChatViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChatViewModel((ChatRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ChatRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory40 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatViewModel.class), null, anonymousClass40, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory40);
                new Pair(module, factoryInstanceFactory40);
                AnonymousClass41 anonymousClass41 = new Function2<Scope, ParametersHolder, CommentDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.41
                    @Override // kotlin.jvm.functions.Function2
                    public final CommentDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CommentDialogViewModel((ChatRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ChatRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory41 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CommentDialogViewModel.class), null, anonymousClass41, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory41);
                new Pair(module, factoryInstanceFactory41);
                AnonymousClass42 anonymousClass42 = new Function2<Scope, ParametersHolder, CommentReplyDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.42
                    @Override // kotlin.jvm.functions.Function2
                    public final CommentReplyDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CommentReplyDialogViewModel((ChatRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ChatRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory42 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CommentReplyDialogViewModel.class), null, anonymousClass42, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory42);
                new Pair(module, factoryInstanceFactory42);
                AnonymousClass43 anonymousClass43 = new Function2<Scope, ParametersHolder, ResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.43
                    @Override // kotlin.jvm.functions.Function2
                    public final ResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResultViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory43 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResultViewModel.class), null, anonymousClass43, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory43);
                new Pair(module, factoryInstanceFactory43);
                AnonymousClass44 anonymousClass44 = new Function2<Scope, ParametersHolder, AssignmentResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.44
                    @Override // kotlin.jvm.functions.Function2
                    public final AssignmentResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AssignmentResultViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory44 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AssignmentResultViewModel.class), null, anonymousClass44, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory44);
                new Pair(module, factoryInstanceFactory44);
                AnonymousClass45 anonymousClass45 = new Function2<Scope, ParametersHolder, SessionalViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.45
                    @Override // kotlin.jvm.functions.Function2
                    public final SessionalViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SessionalViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory45 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SessionalViewModel.class), null, anonymousClass45, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory45);
                new Pair(module, factoryInstanceFactory45);
                AnonymousClass46 anonymousClass46 = new Function2<Scope, ParametersHolder, ResultModuleTestViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.46
                    @Override // kotlin.jvm.functions.Function2
                    public final ResultModuleTestViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResultModuleTestViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory46 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResultModuleTestViewModel.class), null, anonymousClass46, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory46);
                new Pair(module, factoryInstanceFactory46);
                AnonymousClass47 anonymousClass47 = new Function2<Scope, ParametersHolder, TutorialResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.47
                    @Override // kotlin.jvm.functions.Function2
                    public final TutorialResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TutorialResultViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory47 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialResultViewModel.class), null, anonymousClass47, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory47);
                new Pair(module, factoryInstanceFactory47);
                AnonymousClass48 anonymousClass48 = new Function2<Scope, ParametersHolder, InternalResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.48
                    @Override // kotlin.jvm.functions.Function2
                    public final InternalResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InternalResultViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory48 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternalResultViewModel.class), null, anonymousClass48, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory48);
                new Pair(module, factoryInstanceFactory48);
                AnonymousClass49 anonymousClass49 = new Function2<Scope, ParametersHolder, UniversityViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.49
                    @Override // kotlin.jvm.functions.Function2
                    public final UniversityViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UniversityViewModel((ResultRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResultRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory49 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UniversityViewModel.class), null, anonymousClass49, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory49);
                new Pair(module, factoryInstanceFactory49);
                AnonymousClass50 anonymousClass50 = new Function2<Scope, ParametersHolder, UniversityExamsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.50
                    @Override // kotlin.jvm.functions.Function2
                    public final UniversityExamsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UniversityExamsViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory50 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UniversityExamsViewModel.class), null, anonymousClass50, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory50);
                new Pair(module, factoryInstanceFactory50);
                AnonymousClass51 anonymousClass51 = new Function2<Scope, ParametersHolder, UnivInitialPageViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.51
                    @Override // kotlin.jvm.functions.Function2
                    public final UnivInitialPageViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UnivInitialPageViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory51 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UnivInitialPageViewModel.class), null, anonymousClass51, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory51);
                new Pair(module, factoryInstanceFactory51);
                AnonymousClass52 anonymousClass52 = new Function2<Scope, ParametersHolder, SemListDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.52
                    @Override // kotlin.jvm.functions.Function2
                    public final SemListDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemListDialogViewModel((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory52 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemListDialogViewModel.class), null, anonymousClass52, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory52);
                new Pair(module, factoryInstanceFactory52);
                AnonymousClass53 anonymousClass53 = new Function2<Scope, ParametersHolder, SemListDialogViewModelTwo>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.53
                    @Override // kotlin.jvm.functions.Function2
                    public final SemListDialogViewModelTwo invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemListDialogViewModelTwo((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory53 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemListDialogViewModelTwo.class), null, anonymousClass53, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory53);
                new Pair(module, factoryInstanceFactory53);
                AnonymousClass54 anonymousClass54 = new Function2<Scope, ParametersHolder, AttendanceByDayViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.54
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceByDayViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceByDayViewModel((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory54 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceByDayViewModel.class), null, anonymousClass54, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory54);
                new Pair(module, factoryInstanceFactory54);
                AnonymousClass55 anonymousClass55 = new Function2<Scope, ParametersHolder, AttendanceDayDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.55
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceDayDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceDayDialogViewModel((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory55 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceDayDialogViewModel.class), null, anonymousClass55, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory55);
                new Pair(module, factoryInstanceFactory55);
                AnonymousClass56 anonymousClass56 = new Function2<Scope, ParametersHolder, MedicalViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.56
                    @Override // kotlin.jvm.functions.Function2
                    public final MedicalViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MedicalViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory56 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MedicalViewModel.class), null, anonymousClass56, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory56);
                new Pair(module, factoryInstanceFactory56);
                AnonymousClass57 anonymousClass57 = new Function2<Scope, ParametersHolder, AddMedicalLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.57
                    @Override // kotlin.jvm.functions.Function2
                    public final AddMedicalLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddMedicalLeaveViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory57 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddMedicalLeaveViewModel.class), null, anonymousClass57, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory57);
                new Pair(module, factoryInstanceFactory57);
                AnonymousClass58 anonymousClass58 = new Function2<Scope, ParametersHolder, ProofDutyLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.58
                    @Override // kotlin.jvm.functions.Function2
                    public final ProofDutyLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProofDutyLeaveViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory58 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProofDutyLeaveViewModel.class), null, anonymousClass58, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory58);
                new Pair(module, factoryInstanceFactory58);
                AnonymousClass59 anonymousClass59 = new Function2<Scope, ParametersHolder, ViewProofDutyLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.59
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewProofDutyLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewProofDutyLeaveViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory59 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewProofDutyLeaveViewModel.class), null, anonymousClass59, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory59);
                new Pair(module, factoryInstanceFactory59);
                AnonymousClass60 anonymousClass60 = new Function2<Scope, ParametersHolder, DutyLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.60
                    @Override // kotlin.jvm.functions.Function2
                    public final DutyLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DutyLeaveViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory60 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DutyLeaveViewModel.class), null, anonymousClass60, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory60);
                new Pair(module, factoryInstanceFactory60);
                AnonymousClass61 anonymousClass61 = new Function2<Scope, ParametersHolder, MaterialViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.61
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaterialViewModel((MaterialRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MaterialRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory61 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialViewModel.class), null, anonymousClass61, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory61);
                new Pair(module, factoryInstanceFactory61);
                AnonymousClass62 anonymousClass62 = new Function2<Scope, ParametersHolder, QuestionBankViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.62
                    @Override // kotlin.jvm.functions.Function2
                    public final QuestionBankViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuestionBankViewModel((MaterialRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MaterialRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory62 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuestionBankViewModel.class), null, anonymousClass62, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory62);
                new Pair(module, factoryInstanceFactory62);
                AnonymousClass63 anonymousClass63 = new Function2<Scope, ParametersHolder, SeriesExamViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.63
                    @Override // kotlin.jvm.functions.Function2
                    public final SeriesExamViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SeriesExamViewModel((ExamRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory63 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SeriesExamViewModel.class), null, anonymousClass63, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory63);
                new Pair(module, factoryInstanceFactory63);
                AnonymousClass64 anonymousClass64 = new Function2<Scope, ParametersHolder, ModuleTestViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.64
                    @Override // kotlin.jvm.functions.Function2
                    public final ModuleTestViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ModuleTestViewModel((ExamRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory64 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ModuleTestViewModel.class), null, anonymousClass64, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory64);
                new Pair(module, factoryInstanceFactory64);
                AnonymousClass65 anonymousClass65 = new Function2<Scope, ParametersHolder, QuestionDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.65
                    @Override // kotlin.jvm.functions.Function2
                    public final QuestionDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuestionDialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory65 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuestionDialogViewModel.class), null, anonymousClass65, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory65);
                new Pair(module, factoryInstanceFactory65);
                AnonymousClass66 anonymousClass66 = new Function2<Scope, ParametersHolder, SubmitExamDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.66
                    @Override // kotlin.jvm.functions.Function2
                    public final SubmitExamDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubmitExamDialogViewModel((ExamRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory66 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubmitExamDialogViewModel.class), null, anonymousClass66, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory66);
                new Pair(module, factoryInstanceFactory66);
                AnonymousClass67 anonymousClass67 = new Function2<Scope, ParametersHolder, AssignmentViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.67
                    @Override // kotlin.jvm.functions.Function2
                    public final AssignmentViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AssignmentViewModel((AssignmentRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AssignmentRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory67 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AssignmentViewModel.class), null, anonymousClass67, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory67);
                new Pair(module, factoryInstanceFactory67);
                AnonymousClass68 anonymousClass68 = new Function2<Scope, ParametersHolder, UploadAssignmentDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.68
                    @Override // kotlin.jvm.functions.Function2
                    public final UploadAssignmentDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UploadAssignmentDialogViewModel((AssignmentRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AssignmentRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory68 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UploadAssignmentDialogViewModel.class), null, anonymousClass68, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory68);
                new Pair(module, factoryInstanceFactory68);
                AnonymousClass69 anonymousClass69 = new Function2<Scope, ParametersHolder, SemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.69
                    @Override // kotlin.jvm.functions.Function2
                    public final SemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory69 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemRegViewModel.class), null, anonymousClass69, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory69);
                new Pair(module, factoryInstanceFactory69);
                AnonymousClass70 anonymousClass70 = new Function2<Scope, ParametersHolder, SemRegViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.70
                    @Override // kotlin.jvm.functions.Function2
                    public final SemRegViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemRegViewViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory70 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemRegViewViewModel.class), null, anonymousClass70, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory70);
                new Pair(module, factoryInstanceFactory70);
                AnonymousClass71 anonymousClass71 = new Function2<Scope, ParametersHolder, SemRegisterListViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.71
                    @Override // kotlin.jvm.functions.Function2
                    public final SemRegisterListViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemRegisterListViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory71 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemRegisterListViewModel.class), null, anonymousClass71, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory71);
                new Pair(module, factoryInstanceFactory71);
                AnonymousClass72 anonymousClass72 = new Function2<Scope, ParametersHolder, PalaiSemesterRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.72
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiSemesterRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiSemesterRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory72 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiSemesterRegViewModel.class), null, anonymousClass72, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory72);
                new Pair(module, factoryInstanceFactory72);
                AnonymousClass73 anonymousClass73 = new Function2<Scope, ParametersHolder, PalaiNewSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.73
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiNewSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiNewSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory73 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiNewSemRegViewModel.class), null, anonymousClass73, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory73);
                new Pair(module, factoryInstanceFactory73);
                AnonymousClass74 anonymousClass74 = new Function2<Scope, ParametersHolder, MaceNewSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.74
                    @Override // kotlin.jvm.functions.Function2
                    public final MaceNewSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaceNewSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory74 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaceNewSemRegViewModel.class), null, anonymousClass74, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory74);
                new Pair(module, factoryInstanceFactory74);
                AnonymousClass75 anonymousClass75 = new Function2<Scope, ParametersHolder, TutorialViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.75
                    @Override // kotlin.jvm.functions.Function2
                    public final TutorialViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TutorialViewModel((TutorialRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TutorialRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory75 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialViewModel.class), null, anonymousClass75, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory75);
                new Pair(module, factoryInstanceFactory75);
                AnonymousClass76 anonymousClass76 = new Function2<Scope, ParametersHolder, UploadTutorialDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.76
                    @Override // kotlin.jvm.functions.Function2
                    public final UploadTutorialDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UploadTutorialDialogViewModel((TutorialRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TutorialRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory76 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UploadTutorialDialogViewModel.class), null, anonymousClass76, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory76);
                new Pair(module, factoryInstanceFactory76);
                AnonymousClass77 anonymousClass77 = new Function2<Scope, ParametersHolder, HomeWorkViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.77
                    @Override // kotlin.jvm.functions.Function2
                    public final HomeWorkViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HomeWorkViewModel((HomeWorkRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HomeWorkRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory77 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeWorkViewModel.class), null, anonymousClass77, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory77);
                new Pair(module, factoryInstanceFactory77);
                AnonymousClass78 anonymousClass78 = new Function2<Scope, ParametersHolder, SubmitHomeWorkDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.78
                    @Override // kotlin.jvm.functions.Function2
                    public final SubmitHomeWorkDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubmitHomeWorkDialogViewModel((HomeWorkRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HomeWorkRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory78 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubmitHomeWorkDialogViewModel.class), null, anonymousClass78, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory78);
                new Pair(module, factoryInstanceFactory78);
                AnonymousClass79 anonymousClass79 = new Function2<Scope, ParametersHolder, HomeWorkFilesDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.79
                    @Override // kotlin.jvm.functions.Function2
                    public final HomeWorkFilesDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HomeWorkFilesDialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory79 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeWorkFilesDialogViewModel.class), null, anonymousClass79, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory79);
                new Pair(module, factoryInstanceFactory79);
                AnonymousClass80 anonymousClass80 = new Function2<Scope, ParametersHolder, FeeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.80
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeViewModel((FeeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory80 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeViewModel.class), null, anonymousClass80, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory80);
                new Pair(module, factoryInstanceFactory80);
                AnonymousClass81 anonymousClass81 = new Function2<Scope, ParametersHolder, ReceiptViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.81
                    @Override // kotlin.jvm.functions.Function2
                    public final ReceiptViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReceiptViewModel((FeeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory81 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReceiptViewModel.class), null, anonymousClass81, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory81);
                new Pair(module, factoryInstanceFactory81);
                AnonymousClass82 anonymousClass82 = new Function2<Scope, ParametersHolder, ActivityPointViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.82
                    @Override // kotlin.jvm.functions.Function2
                    public final ActivityPointViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ActivityPointViewModel((ActivityPointRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ActivityPointRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory82 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ActivityPointViewModel.class), null, anonymousClass82, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory82);
                new Pair(module, factoryInstanceFactory82);
                AnonymousClass83 anonymousClass83 = new Function2<Scope, ParametersHolder, ManageActivityViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.83
                    @Override // kotlin.jvm.functions.Function2
                    public final ManageActivityViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ManageActivityViewModel((ActivityPointRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ActivityPointRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory83 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ManageActivityViewModel.class), null, anonymousClass83, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory83);
                new Pair(module, factoryInstanceFactory83);
                AnonymousClass84 anonymousClass84 = new Function2<Scope, ParametersHolder, ProofFileDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.84
                    @Override // kotlin.jvm.functions.Function2
                    public final ProofFileDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProofFileDialogViewModel((ActivityPointRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ActivityPointRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory84 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProofFileDialogViewModel.class), null, anonymousClass84, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory84);
                new Pair(module, factoryInstanceFactory84);
                AnonymousClass85 anonymousClass85 = new Function2<Scope, ParametersHolder, GrievanceViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.85
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GrievanceViewModel((GrievanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(GrievanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory85 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceViewModel.class), null, anonymousClass85, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory85);
                new Pair(module, factoryInstanceFactory85);
                AnonymousClass86 anonymousClass86 = new Function2<Scope, ParametersHolder, AddGrievanceDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.86
                    @Override // kotlin.jvm.functions.Function2
                    public final AddGrievanceDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddGrievanceDialogViewModel((GrievanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(GrievanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory86 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddGrievanceDialogViewModel.class), null, anonymousClass86, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory86);
                new Pair(module, factoryInstanceFactory86);
                AnonymousClass87 anonymousClass87 = new Function2<Scope, ParametersHolder, ViewGrievanceViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.87
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewGrievanceViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewGrievanceViewModel((GrievanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(GrievanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory87 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewGrievanceViewModel.class), null, anonymousClass87, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory87);
                new Pair(module, factoryInstanceFactory87);
                AnonymousClass88 anonymousClass88 = new Function2<Scope, ParametersHolder, ActionsDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.88
                    @Override // kotlin.jvm.functions.Function2
                    public final ActionsDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ActionsDialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory88 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ActionsDialogViewModel.class), null, anonymousClass88, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory88);
                new Pair(module, factoryInstanceFactory88);
                AnonymousClass89 anonymousClass89 = new Function2<Scope, ParametersHolder, CellMemberDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.89
                    @Override // kotlin.jvm.functions.Function2
                    public final CellMemberDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CellMemberDialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory89 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CellMemberDialogViewModel.class), null, anonymousClass89, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory89);
                new Pair(module, factoryInstanceFactory89);
                AnonymousClass90 anonymousClass90 = new Function2<Scope, ParametersHolder, GrievanceDocDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.90
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceDocDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GrievanceDocDialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory90 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceDocDialogViewModel.class), null, anonymousClass90, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory90);
                new Pair(module, factoryInstanceFactory90);
                AnonymousClass91 anonymousClass91 = new Function2<Scope, ParametersHolder, RemindDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.91
                    @Override // kotlin.jvm.functions.Function2
                    public final RemindDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RemindDialogViewModel((GrievanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(GrievanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory91 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RemindDialogViewModel.class), null, anonymousClass91, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory91);
                new Pair(module, factoryInstanceFactory91);
                AnonymousClass92 anonymousClass92 = new Function2<Scope, ParametersHolder, CertificateRequestViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.92
                    @Override // kotlin.jvm.functions.Function2
                    public final CertificateRequestViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CertificateRequestViewModel((CertificateRequestRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CertificateRequestRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory92 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertificateRequestViewModel.class), null, anonymousClass92, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory92);
                new Pair(module, factoryInstanceFactory92);
                AnonymousClass93 anonymousClass93 = new Function2<Scope, ParametersHolder, AddRequestDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.93
                    @Override // kotlin.jvm.functions.Function2
                    public final AddRequestDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddRequestDialogViewModel((CertificateRequestRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CertificateRequestRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory93 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddRequestDialogViewModel.class), null, anonymousClass93, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory93);
                new Pair(module, factoryInstanceFactory93);
                AnonymousClass94 anonymousClass94 = new Function2<Scope, ParametersHolder, CovidCertificateDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.94
                    @Override // kotlin.jvm.functions.Function2
                    public final CovidCertificateDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CovidCertificateDialogViewModel((CovidCertificateRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CovidCertificateRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory94 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CovidCertificateDialogViewModel.class), null, anonymousClass94, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory94);
                new Pair(module, factoryInstanceFactory94);
                AnonymousClass95 anonymousClass95 = new Function2<Scope, ParametersHolder, CovidCertificateListMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.95
                    @Override // kotlin.jvm.functions.Function2
                    public final CovidCertificateListMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CovidCertificateListMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory95 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CovidCertificateListMainViewModel.class), null, anonymousClass95, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory95);
                new Pair(module, factoryInstanceFactory95);
                AnonymousClass96 anonymousClass96 = new Function2<Scope, ParametersHolder, CovidCertificateTwoDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.96
                    @Override // kotlin.jvm.functions.Function2
                    public final CovidCertificateTwoDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CovidCertificateTwoDialogViewModel((CovidCertificateRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CovidCertificateRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory96 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CovidCertificateTwoDialogViewModel.class), null, anonymousClass96, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory96);
                new Pair(module, factoryInstanceFactory96);
                AnonymousClass97 anonymousClass97 = new Function2<Scope, ParametersHolder, ResetPasswordViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.97
                    @Override // kotlin.jvm.functions.Function2
                    public final ResetPasswordViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResetPasswordViewModel((ResetPasswordRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ResetPasswordRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory97 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResetPasswordViewModel.class), null, anonymousClass97, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory97);
                new Pair(module, factoryInstanceFactory97);
                AnonymousClass98 anonymousClass98 = new Function2<Scope, ParametersHolder, CounsellingViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.98
                    @Override // kotlin.jvm.functions.Function2
                    public final CounsellingViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CounsellingViewModel((CounsellingRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory98 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounsellingViewModel.class), null, anonymousClass98, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory98);
                new Pair(module, factoryInstanceFactory98);
                AnonymousClass99 anonymousClass99 = new Function2<Scope, ParametersHolder, ViewCounsellingViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.99
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewCounsellingViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewCounsellingViewModel((CounsellingRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory99 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewCounsellingViewModel.class), null, anonymousClass99, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory99);
                new Pair(module, factoryInstanceFactory99);
                AnonymousClass100 anonymousClass100 = new Function2<Scope, ParametersHolder, AddCounsellingViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.100
                    @Override // kotlin.jvm.functions.Function2
                    public final AddCounsellingViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddCounsellingViewModel((CounsellingRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory100 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddCounsellingViewModel.class), null, anonymousClass100, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory100);
                new Pair(module, factoryInstanceFactory100);
                AnonymousClass101 anonymousClass101 = new Function2<Scope, ParametersHolder, ReminderDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.101
                    @Override // kotlin.jvm.functions.Function2
                    public final ReminderDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReminderDialogViewModel((CounsellingRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory101 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReminderDialogViewModel.class), null, anonymousClass101, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory101);
                new Pair(module, factoryInstanceFactory101);
                AnonymousClass102 anonymousClass102 = new Function2<Scope, ParametersHolder, ReviewDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.102
                    @Override // kotlin.jvm.functions.Function2
                    public final ReviewDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReviewDialogViewModel((CounsellingRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CounsellingRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory102 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReviewDialogViewModel.class), null, anonymousClass102, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory102);
                new Pair(module, factoryInstanceFactory102);
                AnonymousClass103 anonymousClass103 = new Function2<Scope, ParametersHolder, Actions2DialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.103
                    @Override // kotlin.jvm.functions.Function2
                    public final Actions2DialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new Actions2DialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory103 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Actions2DialogViewModel.class), null, anonymousClass103, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory103);
                new Pair(module, factoryInstanceFactory103);
                AnonymousClass104 anonymousClass104 = new Function2<Scope, ParametersHolder, CellMember2DialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.104
                    @Override // kotlin.jvm.functions.Function2
                    public final CellMember2DialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CellMember2DialogViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory104 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CellMember2DialogViewModel.class), null, anonymousClass104, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory104);
                new Pair(module, factoryInstanceFactory104);
                AnonymousClass105 anonymousClass105 = new Function2<Scope, ParametersHolder, InternshipViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.105
                    @Override // kotlin.jvm.functions.Function2
                    public final InternshipViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InternshipViewModel((InternshipRepository) viewModel.get(Reflection.getOrCreateKotlinClass(InternshipRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory105 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternshipViewModel.class), null, anonymousClass105, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory105);
                new Pair(module, factoryInstanceFactory105);
                AnonymousClass106 anonymousClass106 = new Function2<Scope, ParametersHolder, ApplyInternshipViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.106
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyInternshipViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyInternshipViewModel((InternshipRepository) viewModel.get(Reflection.getOrCreateKotlinClass(InternshipRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory106 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyInternshipViewModel.class), null, anonymousClass106, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory106);
                new Pair(module, factoryInstanceFactory106);
                AnonymousClass107 anonymousClass107 = new Function2<Scope, ParametersHolder, CompletionCertificateDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.107
                    @Override // kotlin.jvm.functions.Function2
                    public final CompletionCertificateDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CompletionCertificateDialogViewModel((InternshipRepository) viewModel.get(Reflection.getOrCreateKotlinClass(InternshipRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory107 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CompletionCertificateDialogViewModel.class), null, anonymousClass107, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory107);
                new Pair(module, factoryInstanceFactory107);
                AnonymousClass108 anonymousClass108 = new Function2<Scope, ParametersHolder, AddCompanyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.108
                    @Override // kotlin.jvm.functions.Function2
                    public final AddCompanyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddCompanyViewModel((InternshipRepository) viewModel.get(Reflection.getOrCreateKotlinClass(InternshipRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory108 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddCompanyViewModel.class), null, anonymousClass108, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory108);
                new Pair(module, factoryInstanceFactory108);
                AnonymousClass109 anonymousClass109 = new Function2<Scope, ParametersHolder, HostelFeeTkmViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.109
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelFeeTkmViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelFeeTkmViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory109 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelFeeTkmViewModel.class), null, anonymousClass109, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory109);
                new Pair(module, factoryInstanceFactory109);
                AnonymousClass110 anonymousClass110 = new Function2<Scope, ParametersHolder, PalaiHostelViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.110
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiHostelViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiHostelViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory110 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiHostelViewModel.class), null, anonymousClass110, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory110);
                new Pair(module, factoryInstanceFactory110);
                AnonymousClass111 anonymousClass111 = new Function2<Scope, ParametersHolder, PalaiHostelFeeConfirmViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.111
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiHostelFeeConfirmViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiHostelFeeConfirmViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory111 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiHostelFeeConfirmViewModel.class), null, anonymousClass111, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory111);
                new Pair(module, factoryInstanceFactory111);
                AnonymousClass112 anonymousClass112 = new Function2<Scope, ParametersHolder, HostelFeeConfirmViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.112
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelFeeConfirmViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelFeeConfirmViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory112 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelFeeConfirmViewModel.class), null, anonymousClass112, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory112);
                new Pair(module, factoryInstanceFactory112);
                AnonymousClass113 anonymousClass113 = new Function2<Scope, ParametersHolder, PayWebViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.113
                    @Override // kotlin.jvm.functions.Function2
                    public final PayWebViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PayWebViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory113 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PayWebViewModel.class), null, anonymousClass113, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory113);
                new Pair(module, factoryInstanceFactory113);
                AnonymousClass114 anonymousClass114 = new Function2<Scope, ParametersHolder, TkmReceiptViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.114
                    @Override // kotlin.jvm.functions.Function2
                    public final TkmReceiptViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TkmReceiptViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory114 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TkmReceiptViewModel.class), null, anonymousClass114, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory114);
                new Pair(module, factoryInstanceFactory114);
                AnonymousClass115 anonymousClass115 = new Function2<Scope, ParametersHolder, KmeaHostelViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.115
                    @Override // kotlin.jvm.functions.Function2
                    public final KmeaHostelViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new KmeaHostelViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory115 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(KmeaHostelViewModel.class), null, anonymousClass115, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory115);
                new Pair(module, factoryInstanceFactory115);
                AnonymousClass116 anonymousClass116 = new Function2<Scope, ParametersHolder, StoreDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.116
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StoreDialogViewModel((StoreRepository) viewModel.get(Reflection.getOrCreateKotlinClass(StoreRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory116 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreDialogViewModel.class), null, anonymousClass116, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory116);
                new Pair(module, factoryInstanceFactory116);
                AnonymousClass117 anonymousClass117 = new Function2<Scope, ParametersHolder, StoreViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.117
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StoreViewModel((StoreRepository) viewModel.get(Reflection.getOrCreateKotlinClass(StoreRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory117 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreViewModel.class), null, anonymousClass117, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory117);
                new Pair(module, factoryInstanceFactory117);
                AnonymousClass118 anonymousClass118 = new Function2<Scope, ParametersHolder, FeeEngineerViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.118
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeEngineerViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeEngineerViewModel((FeeEngineerRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeEngineerRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory118 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeEngineerViewModel.class), null, anonymousClass118, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory118);
                new Pair(module, factoryInstanceFactory118);
                AnonymousClass119 anonymousClass119 = new Function2<Scope, ParametersHolder, FeeDetailViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.119
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeDetailViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeDetailViewModel((FeeEngineerRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeEngineerRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory119 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeDetailViewModel.class), null, anonymousClass119, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory119);
                new Pair(module, factoryInstanceFactory119);
                AnonymousClass120 anonymousClass120 = new Function2<Scope, ParametersHolder, FeeConfirmViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.120
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeConfirmViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeConfirmViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory120 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeConfirmViewModel.class), null, anonymousClass120, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory120);
                new Pair(module, factoryInstanceFactory120);
                AnonymousClass121 anonymousClass121 = new Function2<Scope, ParametersHolder, FeeArtsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.121
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeArtsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeArtsViewModel((FeeArtsRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeArtsRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory121 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeArtsViewModel.class), null, anonymousClass121, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory121);
                new Pair(module, factoryInstanceFactory121);
                AnonymousClass122 anonymousClass122 = new Function2<Scope, ParametersHolder, VisionDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.122
                    @Override // kotlin.jvm.functions.Function2
                    public final VisionDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new VisionDialogViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory122 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VisionDialogViewModel.class), null, anonymousClass122, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory122);
                new Pair(module, factoryInstanceFactory122);
                AnonymousClass123 anonymousClass123 = new Function2<Scope, ParametersHolder, MissionDialogViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.123
                    @Override // kotlin.jvm.functions.Function2
                    public final MissionDialogViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MissionDialogViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory123 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MissionDialogViewModel.class), null, anonymousClass123, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory123);
                new Pair(module, factoryInstanceFactory123);
                AnonymousClass124 anonymousClass124 = new Function2<Scope, ParametersHolder, ProgramOutcomeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.124
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramOutcomeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramOutcomeViewModel((ProgramOutcomeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ProgramOutcomeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory124 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramOutcomeViewModel.class), null, anonymousClass124, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory124);
                new Pair(module, factoryInstanceFactory124);
                AnonymousClass125 anonymousClass125 = new Function2<Scope, ParametersHolder, DueMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.125
                    @Override // kotlin.jvm.functions.Function2
                    public final DueMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DueMainViewModel((CommonRepository) viewModel.get(Reflection.getOrCreateKotlinClass(CommonRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory125 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DueMainViewModel.class), null, anonymousClass125, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory125);
                new Pair(module, factoryInstanceFactory125);
                AnonymousClass126 anonymousClass126 = new Function2<Scope, ParametersHolder, in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.126
                    @Override // kotlin.jvm.functions.Function2
                    public final in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory126 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationViewModel.class), null, anonymousClass126, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory126);
                new Pair(module, factoryInstanceFactory126);
                AnonymousClass127 anonymousClass127 = new Function2<Scope, ParametersHolder, NewRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.127
                    @Override // kotlin.jvm.functions.Function2
                    public final NewRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NewRegistrationViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory127 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NewRegistrationViewModel.class), null, anonymousClass127, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory127);
                new Pair(module, factoryInstanceFactory127);
                AnonymousClass128 anonymousClass128 = new Function2<Scope, ParametersHolder, ReRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.128
                    @Override // kotlin.jvm.functions.Function2
                    public final ReRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReRegistrationViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory128 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReRegistrationViewModel.class), null, anonymousClass128, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory128);
                new Pair(module, factoryInstanceFactory128);
                AnonymousClass129 anonymousClass129 = new Function2<Scope, ParametersHolder, EditRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.129
                    @Override // kotlin.jvm.functions.Function2
                    public final EditRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new EditRegistrationViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory129 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EditRegistrationViewModel.class), null, anonymousClass129, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory129);
                new Pair(module, factoryInstanceFactory129);
                AnonymousClass130 anonymousClass130 = new Function2<Scope, ParametersHolder, ViewRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.130
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewRegistrationViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory130 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewRegistrationViewModel.class), null, anonymousClass130, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory130);
                new Pair(module, factoryInstanceFactory130);
                AnonymousClass131 anonymousClass131 = new Function2<Scope, ParametersHolder, HostelApplyLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.131
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelApplyLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelApplyLeaveViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory131 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelApplyLeaveViewModel.class), null, anonymousClass131, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory131);
                new Pair(module, factoryInstanceFactory131);
                AnonymousClass132 anonymousClass132 = new Function2<Scope, ParametersHolder, LeaveManagementViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.132
                    @Override // kotlin.jvm.functions.Function2
                    public final LeaveManagementViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LeaveManagementViewModel((LeavemanagementRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeavemanagementRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory132 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveManagementViewModel.class), null, anonymousClass132, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory132);
                new Pair(module, factoryInstanceFactory132);
                AnonymousClass133 anonymousClass133 = new Function2<Scope, ParametersHolder, ChangePasswordViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.133
                    @Override // kotlin.jvm.functions.Function2
                    public final ChangePasswordViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChangePasswordViewModel((ChangePasswordRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ChangePasswordRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory133 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChangePasswordViewModel.class), null, anonymousClass133, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory133);
                new Pair(module, factoryInstanceFactory133);
                AnonymousClass134 anonymousClass134 = new Function2<Scope, ParametersHolder, ExamViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.134
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamViewViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory134 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamViewViewModel.class), null, anonymousClass134, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory134);
                new Pair(module, factoryInstanceFactory134);
                AnonymousClass135 anonymousClass135 = new Function2<Scope, ParametersHolder, ExamSubjectViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.135
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamSubjectViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamSubjectViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory135 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamSubjectViewModel.class), null, anonymousClass135, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory135);
                new Pair(module, factoryInstanceFactory135);
                AnonymousClass136 anonymousClass136 = new Function2<Scope, ParametersHolder, ExamRegisterViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.136
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamRegisterViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamRegisterViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory136 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamRegisterViewModel.class), null, anonymousClass136, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory136);
                new Pair(module, factoryInstanceFactory136);
                AnonymousClass137 anonymousClass137 = new Function2<Scope, ParametersHolder, ExamSubjectDetailViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.137
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamSubjectDetailViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamSubjectDetailViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory137 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamSubjectDetailViewModel.class), null, anonymousClass137, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory137);
                new Pair(module, factoryInstanceFactory137);
                AnonymousClass138 anonymousClass138 = new Function2<Scope, ParametersHolder, UpdateRegisterViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.138
                    @Override // kotlin.jvm.functions.Function2
                    public final UpdateRegisterViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UpdateRegisterViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory138 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UpdateRegisterViewModel.class), null, anonymousClass138, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory138);
                new Pair(module, factoryInstanceFactory138);
                AnonymousClass139 anonymousClass139 = new Function2<Scope, ParametersHolder, ExamReceiptViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.139
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamReceiptViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamReceiptViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory139 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamReceiptViewModel.class), null, anonymousClass139, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory139);
                new Pair(module, factoryInstanceFactory139);
                AnonymousClass140 anonymousClass140 = new Function2<Scope, ParametersHolder, AbcIdVerifyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.140
                    @Override // kotlin.jvm.functions.Function2
                    public final AbcIdVerifyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AbcIdVerifyViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory140 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AbcIdVerifyViewModel.class), null, anonymousClass140, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory140);
                new Pair(module, factoryInstanceFactory140);
                AnonymousClass141 anonymousClass141 = new Function2<Scope, ParametersHolder, AddUpdateBankViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.141
                    @Override // kotlin.jvm.functions.Function2
                    public final AddUpdateBankViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AddUpdateBankViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory141 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddUpdateBankViewModel.class), null, anonymousClass141, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory141);
                new Pair(module, factoryInstanceFactory141);
                AnonymousClass142 anonymousClass142 = new Function2<Scope, ParametersHolder, UniversityResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.142
                    @Override // kotlin.jvm.functions.Function2
                    public final UniversityResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UniversityResultViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory142 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UniversityResultViewModel.class), null, anonymousClass142, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory142);
                new Pair(module, factoryInstanceFactory142);
                AnonymousClass143 anonymousClass143 = new Function2<Scope, ParametersHolder, RevaluationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.143
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory143 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationViewModel.class), null, anonymousClass143, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory143);
                new Pair(module, factoryInstanceFactory143);
                AnonymousClass144 anonymousClass144 = new Function2<Scope, ParametersHolder, RevaluationViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.144
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationViewViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory144 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationViewViewModel.class), null, anonymousClass144, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory144);
                new Pair(module, factoryInstanceFactory144);
                AnonymousClass145 anonymousClass145 = new Function2<Scope, ParametersHolder, RevaluationFeeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.145
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationFeeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationFeeViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory145 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationFeeViewModel.class), null, anonymousClass145, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory145);
                new Pair(module, factoryInstanceFactory145);
                AnonymousClass146 anonymousClass146 = new Function2<Scope, ParametersHolder, RevaluationReceiptViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.146
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationReceiptViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationReceiptViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory146 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationReceiptViewModel.class), null, anonymousClass146, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory146);
                new Pair(module, factoryInstanceFactory146);
                AnonymousClass147 anonymousClass147 = new Function2<Scope, ParametersHolder, RevaluationUpdateViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.147
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationUpdateViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationUpdateViewModel((ExamRegistrationRepository) viewModel.get(Reflection.getOrCreateKotlinClass(ExamRegistrationRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory147 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationUpdateViewModel.class), null, anonymousClass147, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory147);
                new Pair(module, factoryInstanceFactory147);
                AnonymousClass148 anonymousClass148 = new Function2<Scope, ParametersHolder, MessViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.148
                    @Override // kotlin.jvm.functions.Function2
                    public final MessViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MessViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory148 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessViewModel.class), null, anonymousClass148, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory148);
                new Pair(module, factoryInstanceFactory148);
                AnonymousClass149 anonymousClass149 = new Function2<Scope, ParametersHolder, OrderHistoryViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.149
                    @Override // kotlin.jvm.functions.Function2
                    public final OrderHistoryViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OrderHistoryViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory149 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OrderHistoryViewModel.class), null, anonymousClass149, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory149);
                new Pair(module, factoryInstanceFactory149);
                AnonymousClass150 anonymousClass150 = new Function2<Scope, ParametersHolder, MessBookingViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.150
                    @Override // kotlin.jvm.functions.Function2
                    public final MessBookingViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MessBookingViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory150 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessBookingViewModel.class), null, anonymousClass150, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory150);
                new Pair(module, factoryInstanceFactory150);
                AnonymousClass151 anonymousClass151 = new Function2<Scope, ParametersHolder, HostelPartialViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.151
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPartialViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelPartialViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory151 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPartialViewModel.class), null, anonymousClass151, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory151);
                new Pair(module, factoryInstanceFactory151);
                AnonymousClass152 anonymousClass152 = new Function2<Scope, ParametersHolder, HostelViewLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.152
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelViewLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelViewLeaveViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory152 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelViewLeaveViewModel.class), null, anonymousClass152, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory152);
                new Pair(module, factoryInstanceFactory152);
                AnonymousClass153 anonymousClass153 = new Function2<Scope, ParametersHolder, HostelAttendanceViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.153
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelAttendanceViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelAttendanceViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory153 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelAttendanceViewModel.class), null, anonymousClass153, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory153);
                new Pair(module, factoryInstanceFactory153);
                AnonymousClass154 anonymousClass154 = new Function2<Scope, ParametersHolder, HostelAttendanceParentViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.154
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelAttendanceParentViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelAttendanceParentViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory154 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelAttendanceParentViewModel.class), null, anonymousClass154, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory154);
                new Pair(module, factoryInstanceFactory154);
                AnonymousClass155 anonymousClass155 = new Function2<Scope, ParametersHolder, SecurityQrViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.155
                    @Override // kotlin.jvm.functions.Function2
                    public final SecurityQrViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SecurityQrViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory155 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SecurityQrViewModel.class), null, anonymousClass155, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory155);
                new Pair(module, factoryInstanceFactory155);
                AnonymousClass156 anonymousClass156 = new Function2<Scope, ParametersHolder, TransportFeeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.156
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportFeeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportFeeViewModel((FeeEngineerRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeEngineerRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory156 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportFeeViewModel.class), null, anonymousClass156, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory156);
                new Pair(module, factoryInstanceFactory156);
                AnonymousClass157 anonymousClass157 = new Function2<Scope, ParametersHolder, TransportReceiptViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.157
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportReceiptViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportReceiptViewModel((FeeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory157 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportReceiptViewModel.class), null, anonymousClass157, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory157);
                new Pair(module, factoryInstanceFactory157);
                AnonymousClass158 anonymousClass158 = new Function2<Scope, ParametersHolder, UpdateAbcViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.158
                    @Override // kotlin.jvm.functions.Function2
                    public final UpdateAbcViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UpdateAbcViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory158 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UpdateAbcViewModel.class), null, anonymousClass158, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory158);
                new Pair(module, factoryInstanceFactory158);
                AnonymousClass159 anonymousClass159 = new Function2<Scope, ParametersHolder, BookViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.159
                    @Override // kotlin.jvm.functions.Function2
                    public final BookViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookViewModel((LibraryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LibraryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory159 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookViewModel.class), null, anonymousClass159, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory159);
                new Pair(module, factoryInstanceFactory159);
                AnonymousClass160 anonymousClass160 = new Function2<Scope, ParametersHolder, BookDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.160
                    @Override // kotlin.jvm.functions.Function2
                    public final BookDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookDetailsViewModel((LibraryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LibraryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory160 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookDetailsViewModel.class), null, anonymousClass160, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory160);
                new Pair(module, factoryInstanceFactory160);
                AnonymousClass161 anonymousClass161 = new Function2<Scope, ParametersHolder, BookRecordViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.161
                    @Override // kotlin.jvm.functions.Function2
                    public final BookRecordViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookRecordViewModel((LibraryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LibraryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory161 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookRecordViewModel.class), null, anonymousClass161, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory161);
                new Pair(module, factoryInstanceFactory161);
                AnonymousClass162 anonymousClass162 = new Function2<Scope, ParametersHolder, SuggestBookViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.162
                    @Override // kotlin.jvm.functions.Function2
                    public final SuggestBookViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SuggestBookViewModel((LibraryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LibraryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory162 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SuggestBookViewModel.class), null, anonymousClass162, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory162);
                new Pair(module, factoryInstanceFactory162);
                AnonymousClass163 anonymousClass163 = new Function2<Scope, ParametersHolder, GatewayViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.163
                    @Override // kotlin.jvm.functions.Function2
                    public final GatewayViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GatewayViewModel((FeeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory163 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GatewayViewModel.class), null, anonymousClass163, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory163);
                new Pair(module, factoryInstanceFactory163);
                AnonymousClass164 anonymousClass164 = new Function2<Scope, ParametersHolder, TransportRegHistoryViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.164
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportRegHistoryViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportRegHistoryViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory164 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportRegHistoryViewModel.class), null, anonymousClass164, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory164);
                new Pair(module, factoryInstanceFactory164);
                AnonymousClass165 anonymousClass165 = new Function2<Scope, ParametersHolder, TransportRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.165
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportRegistrationViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory165 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportRegistrationViewModel.class), null, anonymousClass165, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory165);
                new Pair(module, factoryInstanceFactory165);
                AnonymousClass166 anonymousClass166 = new Function2<Scope, ParametersHolder, in.etuwa.app.ui.transport.payment.TransportFeeViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.166
                    @Override // kotlin.jvm.functions.Function2
                    public final in.etuwa.app.ui.transport.payment.TransportFeeViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new in.etuwa.app.ui.transport.payment.TransportFeeViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory166 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(in.etuwa.app.ui.transport.payment.TransportFeeViewModel.class), null, anonymousClass166, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory166);
                new Pair(module, factoryInstanceFactory166);
                AnonymousClass167 anonymousClass167 = new Function2<Scope, ParametersHolder, BusPassViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.167
                    @Override // kotlin.jvm.functions.Function2
                    public final BusPassViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BusPassViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory167 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BusPassViewModel.class), null, anonymousClass167, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory167);
                new Pair(module, factoryInstanceFactory167);
                AnonymousClass168 anonymousClass168 = new Function2<Scope, ParametersHolder, TransportHistoryViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.168
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportHistoryViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportHistoryViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory168 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportHistoryViewModel.class), null, anonymousClass168, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory168);
                new Pair(module, factoryInstanceFactory168);
                AnonymousClass169 anonymousClass169 = new Function2<Scope, ParametersHolder, QrFullScreenViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.169
                    @Override // kotlin.jvm.functions.Function2
                    public final QrFullScreenViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QrFullScreenViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory169 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QrFullScreenViewModel.class), null, anonymousClass169, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory169);
                new Pair(module, factoryInstanceFactory169);
                AnonymousClass170 anonymousClass170 = new Function2<Scope, ParametersHolder, UpdateProfileViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.170
                    @Override // kotlin.jvm.functions.Function2
                    public final UpdateProfileViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UpdateProfileViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory170 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UpdateProfileViewModel.class), null, anonymousClass170, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory170);
                new Pair(module, factoryInstanceFactory170);
                AnonymousClass171 anonymousClass171 = new Function2<Scope, ParametersHolder, FeeMedicalViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.171
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeMedicalViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeMedicalViewModel((FeeRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory171 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeMedicalViewModel.class), null, anonymousClass171, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory171);
                new Pair(module, factoryInstanceFactory171);
                AnonymousClass172 anonymousClass172 = new Function2<Scope, ParametersHolder, FeeListViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.172
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeListViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeListViewModel((FeeEngineerRepository) viewModel.get(Reflection.getOrCreateKotlinClass(FeeEngineerRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory172 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeListViewModel.class), null, anonymousClass172, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory172);
                new Pair(module, factoryInstanceFactory172);
                AnonymousClass173 anonymousClass173 = new Function2<Scope, ParametersHolder, DirectApplyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.173
                    @Override // kotlin.jvm.functions.Function2
                    public final DirectApplyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DirectApplyViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory173 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DirectApplyViewModel.class), null, anonymousClass173, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory173);
                new Pair(module, factoryInstanceFactory173);
                AnonymousClass174 anonymousClass174 = new Function2<Scope, ParametersHolder, ViewProofViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.174
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewProofViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewProofViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory174 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewProofViewModel.class), null, anonymousClass174, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory174);
                new Pair(module, factoryInstanceFactory174);
                AnonymousClass175 anonymousClass175 = new Function2<Scope, ParametersHolder, ApplyDirectDutyLeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.175
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyDirectDutyLeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyDirectDutyLeaveViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory175 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyDirectDutyLeaveViewModel.class), null, anonymousClass175, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory175);
                new Pair(module, factoryInstanceFactory175);
                AnonymousClass176 anonymousClass176 = new Function2<Scope, ParametersHolder, UpdateHoursDirectViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.176
                    @Override // kotlin.jvm.functions.Function2
                    public final UpdateHoursDirectViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UpdateHoursDirectViewModel((LeaveRepository) viewModel.get(Reflection.getOrCreateKotlinClass(LeaveRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory176 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UpdateHoursDirectViewModel.class), null, anonymousClass176, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory176);
                new Pair(module, factoryInstanceFactory176);
                AnonymousClass177 anonymousClass177 = new Function2<Scope, ParametersHolder, HostelPartialEditViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.177
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPartialEditViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelPartialEditViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory177 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPartialEditViewModel.class), null, anonymousClass177, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory177);
                new Pair(module, factoryInstanceFactory177);
                AnonymousClass178 anonymousClass178 = new Function2<Scope, ParametersHolder, MvjceSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.178
                    @Override // kotlin.jvm.functions.Function2
                    public final MvjceSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MvjceSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory178 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MvjceSemRegViewModel.class), null, anonymousClass178, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory178);
                new Pair(module, factoryInstanceFactory178);
                AnonymousClass179 anonymousClass179 = new Function2<Scope, ParametersHolder, MaterialDownloadViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.179
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialDownloadViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaterialDownloadViewModel((MaterialRepository) viewModel.get(Reflection.getOrCreateKotlinClass(MaterialRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory179 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialDownloadViewModel.class), null, anonymousClass179, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory179);
                new Pair(module, factoryInstanceFactory179);
                AnonymousClass180 anonymousClass180 = new Function2<Scope, ParametersHolder, DayWiseTimeTableViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.180
                    @Override // kotlin.jvm.functions.Function2
                    public final DayWiseTimeTableViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DayWiseTimeTableViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory180 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DayWiseTimeTableViewModel.class), null, anonymousClass180, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory180);
                new Pair(module, factoryInstanceFactory180);
                AnonymousClass181 anonymousClass181 = new Function2<Scope, ParametersHolder, MaintenanceViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.181
                    @Override // kotlin.jvm.functions.Function2
                    public final MaintenanceViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaintenanceViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory181 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaintenanceViewModel.class), null, anonymousClass181, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory181);
                new Pair(module, factoryInstanceFactory181);
                AnonymousClass182 anonymousClass182 = new Function2<Scope, ParametersHolder, SubjectPlanViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.182
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectPlanViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectPlanViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory182 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectPlanViewModel.class), null, anonymousClass182, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory182);
                new Pair(module, factoryInstanceFactory182);
                AnonymousClass183 anonymousClass183 = new Function2<Scope, ParametersHolder, MeaSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.183
                    @Override // kotlin.jvm.functions.Function2
                    public final MeaSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MeaSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory183 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MeaSemRegViewModel.class), null, anonymousClass183, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory183);
                new Pair(module, factoryInstanceFactory183);
                AnonymousClass184 anonymousClass184 = new Function2<Scope, ParametersHolder, AsietSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.184
                    @Override // kotlin.jvm.functions.Function2
                    public final AsietSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AsietSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory184 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AsietSemRegViewModel.class), null, anonymousClass184, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory184);
                new Pair(module, factoryInstanceFactory184);
                AnonymousClass185 anonymousClass185 = new Function2<Scope, ParametersHolder, MitsHostelViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.185
                    @Override // kotlin.jvm.functions.Function2
                    public final MitsHostelViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MitsHostelViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory185 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MitsHostelViewModel.class), null, anonymousClass185, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory185);
                new Pair(module, factoryInstanceFactory185);
                AnonymousClass186 anonymousClass186 = new Function2<Scope, ParametersHolder, LogoutChangePasswordViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.186
                    @Override // kotlin.jvm.functions.Function2
                    public final LogoutChangePasswordViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LogoutChangePasswordViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory186 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LogoutChangePasswordViewModel.class), null, anonymousClass186, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory186);
                new Pair(module, factoryInstanceFactory186);
                AnonymousClass187 anonymousClass187 = new Function2<Scope, ParametersHolder, LeaveViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.187
                    @Override // kotlin.jvm.functions.Function2
                    public final LeaveViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LeaveViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory187 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveViewModel.class), null, anonymousClass187, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory187);
                new Pair(module, factoryInstanceFactory187);
                AnonymousClass188 anonymousClass188 = new Function2<Scope, ParametersHolder, FeeMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.188
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory188 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeMainViewModel.class), null, anonymousClass188, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory188);
                new Pair(module, factoryInstanceFactory188);
                AnonymousClass189 anonymousClass189 = new Function2<Scope, ParametersHolder, AsietTransRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.189
                    @Override // kotlin.jvm.functions.Function2
                    public final AsietTransRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AsietTransRegViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory189 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AsietTransRegViewModel.class), null, anonymousClass189, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory189);
                new Pair(module, factoryInstanceFactory189);
                AnonymousClass190 anonymousClass190 = new Function2<Scope, ParametersHolder, in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.190
                    @Override // kotlin.jvm.functions.Function2
                    public final in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel((TransportRepository) viewModel.get(Reflection.getOrCreateKotlinClass(TransportRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory190 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel.class), null, anonymousClass190, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory190);
                new Pair(module, factoryInstanceFactory190);
                AnonymousClass191 anonymousClass191 = new Function2<Scope, ParametersHolder, NewQuizViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.191
                    @Override // kotlin.jvm.functions.Function2
                    public final NewQuizViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NewQuizViewModel((QuizRepository) viewModel.get(Reflection.getOrCreateKotlinClass(QuizRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory191 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NewQuizViewModel.class), null, anonymousClass191, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory191);
                new Pair(module, factoryInstanceFactory191);
                AnonymousClass192 anonymousClass192 = new Function2<Scope, ParametersHolder, QuizQuestionsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.192
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizQuestionsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizQuestionsViewModel((QuizRepository) viewModel.get(Reflection.getOrCreateKotlinClass(QuizRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory192 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizQuestionsViewModel.class), null, anonymousClass192, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory192);
                new Pair(module, factoryInstanceFactory192);
                AnonymousClass193 anonymousClass193 = new Function2<Scope, ParametersHolder, QuizResultViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.193
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizResultViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizResultViewModel((QuizRepository) viewModel.get(Reflection.getOrCreateKotlinClass(QuizRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory193 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizResultViewModel.class), null, anonymousClass193, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory193);
                new Pair(module, factoryInstanceFactory193);
                AnonymousClass194 anonymousClass194 = new Function2<Scope, ParametersHolder, SurveyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.194
                    @Override // kotlin.jvm.functions.Function2
                    public final SurveyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SurveyViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory194 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SurveyViewModel.class), null, anonymousClass194, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory194);
                new Pair(module, factoryInstanceFactory194);
                AnonymousClass195 anonymousClass195 = new Function2<Scope, ParametersHolder, TeacherSurveyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.195
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherSurveyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherSurveyViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory195 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherSurveyViewModel.class), null, anonymousClass195, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory195);
                new Pair(module, factoryInstanceFactory195);
                AnonymousClass196 anonymousClass196 = new Function2<Scope, ParametersHolder, TeacherSurveyQuestionViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.196
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherSurveyQuestionViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherSurveyQuestionViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory196 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionViewModel.class), null, anonymousClass196, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory196);
                new Pair(module, factoryInstanceFactory196);
                AnonymousClass197 anonymousClass197 = new Function2<Scope, ParametersHolder, HostelMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.197
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory197 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelMainViewModel.class), null, anonymousClass197, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory197);
                new Pair(module, factoryInstanceFactory197);
                AnonymousClass198 anonymousClass198 = new Function2<Scope, ParametersHolder, LabViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.198
                    @Override // kotlin.jvm.functions.Function2
                    public final LabViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory198 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabViewModel.class), null, anonymousClass198, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory198);
                new Pair(module, factoryInstanceFactory198);
                AnonymousClass199 anonymousClass199 = new Function2<Scope, ParametersHolder, ProgramOutcomeMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.199
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramOutcomeMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramOutcomeMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory199 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramOutcomeMainViewModel.class), null, anonymousClass199, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory199);
                new Pair(module, factoryInstanceFactory199);
                AnonymousClass200 anonymousClass200 = new Function2<Scope, ParametersHolder, CourseEvaluationSurveyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.200
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseEvaluationSurveyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseEvaluationSurveyViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory200 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseEvaluationSurveyViewModel.class), null, anonymousClass200, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory200);
                new Pair(module, factoryInstanceFactory200);
                AnonymousClass201 anonymousClass201 = new Function2<Scope, ParametersHolder, CourseSurveySubjectsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.201
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseSurveySubjectsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseSurveySubjectsViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory201 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseSurveySubjectsViewModel.class), null, anonymousClass201, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory201);
                new Pair(module, factoryInstanceFactory201);
                AnonymousClass202 anonymousClass202 = new Function2<Scope, ParametersHolder, CourseSurveyQuestionsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.202
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseSurveyQuestionsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseSurveyQuestionsViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory202 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseSurveyQuestionsViewModel.class), null, anonymousClass202, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory202);
                new Pair(module, factoryInstanceFactory202);
                AnonymousClass203 anonymousClass203 = new Function2<Scope, ParametersHolder, POSurveyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.203
                    @Override // kotlin.jvm.functions.Function2
                    public final POSurveyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new POSurveyViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory203 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(POSurveyViewModel.class), null, anonymousClass203, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory203);
                new Pair(module, factoryInstanceFactory203);
                AnonymousClass204 anonymousClass204 = new Function2<Scope, ParametersHolder, POSurveyQuestionsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.204
                    @Override // kotlin.jvm.functions.Function2
                    public final POSurveyQuestionsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new POSurveyQuestionsViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory204 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(POSurveyQuestionsViewModel.class), null, anonymousClass204, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory204);
                new Pair(module, factoryInstanceFactory204);
                AnonymousClass205 anonymousClass205 = new Function2<Scope, ParametersHolder, GraduateExitSurveyViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.205
                    @Override // kotlin.jvm.functions.Function2
                    public final GraduateExitSurveyViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GraduateExitSurveyViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory205 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GraduateExitSurveyViewModel.class), null, anonymousClass205, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory205);
                new Pair(module, factoryInstanceFactory205);
                AnonymousClass206 anonymousClass206 = new Function2<Scope, ParametersHolder, GraduateSurveyQuestionsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.206
                    @Override // kotlin.jvm.functions.Function2
                    public final GraduateSurveyQuestionsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GraduateSurveyQuestionsViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory206 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsViewModel.class), null, anonymousClass206, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory206);
                new Pair(module, factoryInstanceFactory206);
                AnonymousClass207 anonymousClass207 = new Function2<Scope, ParametersHolder, AttendanceCalendarViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.207
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceCalendarViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceCalendarViewViewModel((AttendanceRepository) viewModel.get(Reflection.getOrCreateKotlinClass(AttendanceRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory207 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceCalendarViewViewModel.class), null, anonymousClass207, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory207);
                new Pair(module, factoryInstanceFactory207);
                AnonymousClass208 anonymousClass208 = new Function2<Scope, ParametersHolder, StationaryMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.208
                    @Override // kotlin.jvm.functions.Function2
                    public final StationaryMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StationaryMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory208 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StationaryMainViewModel.class), null, anonymousClass208, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory208);
                new Pair(module, factoryInstanceFactory208);
                AnonymousClass209 anonymousClass209 = new Function2<Scope, ParametersHolder, BookingViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.209
                    @Override // kotlin.jvm.functions.Function2
                    public final BookingViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookingViewModel((StationaryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(StationaryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory209 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookingViewModel.class), null, anonymousClass209, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory209);
                new Pair(module, factoryInstanceFactory209);
                AnonymousClass210 anonymousClass210 = new Function2<Scope, ParametersHolder, BookingHistoryViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.210
                    @Override // kotlin.jvm.functions.Function2
                    public final BookingHistoryViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookingHistoryViewModel((StationaryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(StationaryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory210 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookingHistoryViewModel.class), null, anonymousClass210, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory210);
                new Pair(module, factoryInstanceFactory210);
                AnonymousClass211 anonymousClass211 = new Function2<Scope, ParametersHolder, OrderPageViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.211
                    @Override // kotlin.jvm.functions.Function2
                    public final OrderPageViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OrderPageViewModel((StationaryRepository) viewModel.get(Reflection.getOrCreateKotlinClass(StationaryRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory211 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OrderPageViewModel.class), null, anonymousClass211, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory211);
                new Pair(module, factoryInstanceFactory211);
                AnonymousClass212 anonymousClass212 = new Function2<Scope, ParametersHolder, HostelNewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.212
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory212 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewViewModel.class), null, anonymousClass212, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory212);
                new Pair(module, factoryInstanceFactory212);
                AnonymousClass213 anonymousClass213 = new Function2<Scope, ParametersHolder, HostelNewDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.213
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewDetailsViewModel((HostelRepository) viewModel.get(Reflection.getOrCreateKotlinClass(HostelRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory213 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewDetailsViewModel.class), null, anonymousClass213, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory213);
                new Pair(module, factoryInstanceFactory213);
                AnonymousClass214 anonymousClass214 = new Function2<Scope, ParametersHolder, HostelNewConfirmViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.214
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewConfirmViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewConfirmViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory214 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewConfirmViewModel.class), null, anonymousClass214, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory214);
                new Pair(module, factoryInstanceFactory214);
                AnonymousClass215 anonymousClass215 = new Function2<Scope, ParametersHolder, ExamMainViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.215
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamMainViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamMainViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory215 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamMainViewModel.class), null, anonymousClass215, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory215);
                new Pair(module, factoryInstanceFactory215);
                AnonymousClass216 anonymousClass216 = new Function2<Scope, ParametersHolder, ExamRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.216
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamRegistrationViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory216 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamRegistrationViewModel.class), null, anonymousClass216, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory216);
                new Pair(module, factoryInstanceFactory216);
                AnonymousClass217 anonymousClass217 = new Function2<Scope, ParametersHolder, SubjectRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.217
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectRegistrationViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory217 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRegistrationViewModel.class), null, anonymousClass217, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory217);
                new Pair(module, factoryInstanceFactory217);
                AnonymousClass218 anonymousClass218 = new Function2<Scope, ParametersHolder, ViewSubjectRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.218
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewSubjectRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewSubjectRegistrationViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory218 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewSubjectRegistrationViewModel.class), null, anonymousClass218, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory218);
                new Pair(module, factoryInstanceFactory218);
                AnonymousClass219 anonymousClass219 = new Function2<Scope, ParametersHolder, ApplySubjectRegistrationViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.219
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplySubjectRegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplySubjectRegistrationViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory219 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationViewModel.class), null, anonymousClass219, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory219);
                new Pair(module, factoryInstanceFactory219);
                AnonymousClass220 anonymousClass220 = new Function2<Scope, ParametersHolder, PersonalDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.220
                    @Override // kotlin.jvm.functions.Function2
                    public final PersonalDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PersonalDetailsViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory220 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PersonalDetailsViewModel.class), null, anonymousClass220, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory220);
                new Pair(module, factoryInstanceFactory220);
                AnonymousClass221 anonymousClass221 = new Function2<Scope, ParametersHolder, ParentDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.221
                    @Override // kotlin.jvm.functions.Function2
                    public final ParentDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ParentDetailsViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory221 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ParentDetailsViewModel.class), null, anonymousClass221, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory221);
                new Pair(module, factoryInstanceFactory221);
                AnonymousClass222 anonymousClass222 = new Function2<Scope, ParametersHolder, ContactDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.222
                    @Override // kotlin.jvm.functions.Function2
                    public final ContactDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ContactDetailsViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory222 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ContactDetailsViewModel.class), null, anonymousClass222, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory222);
                new Pair(module, factoryInstanceFactory222);
                AnonymousClass223 anonymousClass223 = new Function2<Scope, ParametersHolder, ChristSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.223
                    @Override // kotlin.jvm.functions.Function2
                    public final ChristSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChristSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory223 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChristSemRegViewModel.class), null, anonymousClass223, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory223);
                new Pair(module, factoryInstanceFactory223);
                AnonymousClass224 anonymousClass224 = new Function2<Scope, ParametersHolder, ViewMvjceSemRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.224
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewMvjceSemRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewMvjceSemRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory224 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewMvjceSemRegViewModel.class), null, anonymousClass224, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory224);
                new Pair(module, factoryInstanceFactory224);
                AnonymousClass225 anonymousClass225 = new Function2<Scope, ParametersHolder, PaymentWebViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.225
                    @Override // kotlin.jvm.functions.Function2
                    public final PaymentWebViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PaymentWebViewViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory225 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PaymentWebViewViewModel.class), null, anonymousClass225, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory225);
                new Pair(module, factoryInstanceFactory225);
                AnonymousClass226 anonymousClass226 = new Function2<Scope, ParametersHolder, BankDetailsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.226
                    @Override // kotlin.jvm.functions.Function2
                    public final BankDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BankDetailsViewModel((DashRepository) viewModel.get(Reflection.getOrCreateKotlinClass(DashRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory226 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BankDetailsViewModel.class), null, anonymousClass226, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory226);
                new Pair(module, factoryInstanceFactory226);
                AnonymousClass227 anonymousClass227 = new Function2<Scope, ParametersHolder, GatewayTwoViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.227
                    @Override // kotlin.jvm.functions.Function2
                    public final GatewayTwoViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GatewayTwoViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory227 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GatewayTwoViewModel.class), null, anonymousClass227, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory227);
                new Pair(module, factoryInstanceFactory227);
                AnonymousClass228 anonymousClass228 = new Function2<Scope, ParametersHolder, WebViewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.228
                    @Override // kotlin.jvm.functions.Function2
                    public final WebViewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new WebViewViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory228 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(WebViewViewModel.class), null, anonymousClass228, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory228);
                new Pair(module, factoryInstanceFactory228);
                AnonymousClass229 anonymousClass229 = new Function2<Scope, ParametersHolder, FieldsViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.229
                    @Override // kotlin.jvm.functions.Function2
                    public final FieldsViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FieldsViewModel();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory229 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FieldsViewModel.class), null, anonymousClass229, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory229);
                new Pair(module, factoryInstanceFactory229);
                AnonymousClass230 anonymousClass230 = new Function2<Scope, ParametersHolder, PoSurveyQuestionsNewViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.230
                    @Override // kotlin.jvm.functions.Function2
                    public final PoSurveyQuestionsNewViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PoSurveyQuestionsNewViewModel((SurveyRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SurveyRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory230 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PoSurveyQuestionsNewViewModel.class), null, anonymousClass230, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory230);
                new Pair(module, factoryInstanceFactory230);
                AnonymousClass231 anonymousClass231 = new Function2<Scope, ParametersHolder, ApplyPreferenceSubRegViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.231
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyPreferenceSubRegViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyPreferenceSubRegViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory231 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegViewModel.class), null, anonymousClass231, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory231);
                new Pair(module, factoryInstanceFactory231);
                AnonymousClass232 anonymousClass232 = new Function2<Scope, ParametersHolder, SubjectRegStatusViewModel>() { // from class: in.etuwa.app.di.ModulesKt$ViewModelModule$1.232
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRegStatusViewModel invoke(Scope viewModel, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectRegStatusViewModel((SemRegRepository) viewModel.get(Reflection.getOrCreateKotlinClass(SemRegRepository.class), null, null));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory232 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRegStatusViewModel.class), null, anonymousClass232, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory232);
                new Pair(module, factoryInstanceFactory232);
            }
        }, 1, null);
        ViewModelModule = module$default4;
        Module module$default5 = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, FeeArtsSemSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeArtsSemSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new FeeArtsSemSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeArtsSemSpinnerAdapter.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory);
                new Pair(module, factoryInstanceFactory);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, CollegeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final CollegeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CollegeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CollegeSpinnerAdapter.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory2);
                new Pair(module, factoryInstanceFactory2);
                AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, SemesterSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.3
                    @Override // kotlin.jvm.functions.Function2
                    public final SemesterSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new SemesterSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), null, anonymousClass3, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory3);
                new Pair(module, factoryInstanceFactory3);
                AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, ListSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.4
                    @Override // kotlin.jvm.functions.Function2
                    public final ListSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new ListSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ListSpinnerAdapter.class), null, anonymousClass4, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory4);
                new Pair(module, factoryInstanceFactory4);
                AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, MaterialFilterAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.5
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialFilterAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new MaterialFilterAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialFilterAdapter.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory5);
                new Pair(module, factoryInstanceFactory5);
                AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, MaterialModuleAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.6
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialModuleAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new MaterialModuleAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialModuleAdapter.class), null, anonymousClass6, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory6);
                new Pair(module, factoryInstanceFactory6);
                AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, FeeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.7
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new FeeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeSpinnerAdapter.class), null, anonymousClass7, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory7);
                new Pair(module, factoryInstanceFactory7);
                AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, GrievanceTypeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.8
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceTypeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new GrievanceTypeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceTypeSpinnerAdapter.class), null, anonymousClass8, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory8);
                new Pair(module, factoryInstanceFactory8);
                AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, CounsellingTypeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.9
                    @Override // kotlin.jvm.functions.Function2
                    public final CounsellingTypeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CounsellingTypeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounsellingTypeSpinnerAdapter.class), null, anonymousClass9, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory9);
                new Pair(module, factoryInstanceFactory9);
                AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.10
                    @Override // kotlin.jvm.functions.Function2
                    public final CounsellingStatusSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CounsellingStatusSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), null, anonymousClass10, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory10);
                new Pair(module, factoryInstanceFactory10);
                AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, InternshipCompanySpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.11
                    @Override // kotlin.jvm.functions.Function2
                    public final InternshipCompanySpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new InternshipCompanySpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternshipCompanySpinnerAdapter.class), null, anonymousClass11, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory11);
                new Pair(module, factoryInstanceFactory11);
                AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, StoreSemesterAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.12
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreSemesterAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new StoreSemesterAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreSemesterAdapter.class), null, anonymousClass12, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory12);
                new Pair(module, factoryInstanceFactory12);
                AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, StoreDepartmentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.13
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreDepartmentAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new StoreDepartmentAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreDepartmentAdapter.class), null, anonymousClass13, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory13);
                new Pair(module, factoryInstanceFactory13);
                AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, StoreCategoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.14
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreCategoryAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new StoreCategoryAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreCategoryAdapter.class), null, anonymousClass14, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory14);
                new Pair(module, factoryInstanceFactory14);
                AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, StoreSubjectAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.15
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreSubjectAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new StoreSubjectAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreSubjectAdapter.class), null, anonymousClass15, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory15);
                new Pair(module, factoryInstanceFactory15);
                AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, CategorySpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.16
                    @Override // kotlin.jvm.functions.Function2
                    public final CategorySpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CategorySpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CategorySpinnerAdapter.class), null, anonymousClass16, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory16);
                new Pair(module, factoryInstanceFactory16);
                AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, ReAdmissionSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.17
                    @Override // kotlin.jvm.functions.Function2
                    public final ReAdmissionSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new ReAdmissionSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReAdmissionSpinnerAdapter.class), null, anonymousClass17, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory17);
                new Pair(module, factoryInstanceFactory17);
                AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, DefaulterSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.18
                    @Override // kotlin.jvm.functions.Function2
                    public final DefaulterSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new DefaulterSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DefaulterSpinnerAdapter.class), null, anonymousClass18, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory18);
                new Pair(module, factoryInstanceFactory18);
                AnonymousClass19 anonymousClass19 = new Function2<Scope, ParametersHolder, NoOfYearSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.19
                    @Override // kotlin.jvm.functions.Function2
                    public final NoOfYearSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new NoOfYearSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory19 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NoOfYearSpinnerAdapter.class), null, anonymousClass19, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory19);
                new Pair(module, factoryInstanceFactory19);
                AnonymousClass20 anonymousClass20 = new Function2<Scope, ParametersHolder, PresentHostelSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.20
                    @Override // kotlin.jvm.functions.Function2
                    public final PresentHostelSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new PresentHostelSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory20 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PresentHostelSpinnerAdapter.class), null, anonymousClass20, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory20);
                new Pair(module, factoryInstanceFactory20);
                AnonymousClass21 anonymousClass21 = new Function2<Scope, ParametersHolder, FineSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.21
                    @Override // kotlin.jvm.functions.Function2
                    public final FineSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new FineSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory21 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FineSpinnerAdapter.class), null, anonymousClass21, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory21);
                new Pair(module, factoryInstanceFactory21);
                AnonymousClass22 anonymousClass22 = new Function2<Scope, ParametersHolder, AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.22
                    @Override // kotlin.jvm.functions.Function2
                    public final AcademicYearSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new AcademicYearSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory22 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), null, anonymousClass22, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory22);
                new Pair(module, factoryInstanceFactory22);
                AnonymousClass23 anonymousClass23 = new Function2<Scope, ParametersHolder, SemesterRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.23
                    @Override // kotlin.jvm.functions.Function2
                    public final SemesterRegistrationSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new SemesterRegistrationSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory23 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemesterRegistrationSpinnerAdapter.class), null, anonymousClass23, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory23);
                new Pair(module, factoryInstanceFactory23);
                AnonymousClass24 anonymousClass24 = new Function2<Scope, ParametersHolder, MessMenuSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.24
                    @Override // kotlin.jvm.functions.Function2
                    public final MessMenuSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new MessMenuSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory24 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessMenuSpinnerAdapter.class), null, anonymousClass24, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory24);
                new Pair(module, factoryInstanceFactory24);
                AnonymousClass25 anonymousClass25 = new Function2<Scope, ParametersHolder, MessTypeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.25
                    @Override // kotlin.jvm.functions.Function2
                    public final MessTypeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new MessTypeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory25 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessTypeSpinnerAdapter.class), null, anonymousClass25, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory25);
                new Pair(module, factoryInstanceFactory25);
                AnonymousClass26 anonymousClass26 = new Function2<Scope, ParametersHolder, HostelPalaiSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.26
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPalaiSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new HostelPalaiSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory26 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPalaiSpinnerAdapter.class), null, anonymousClass26, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory26);
                new Pair(module, factoryInstanceFactory26);
                AnonymousClass27 anonymousClass27 = new Function2<Scope, ParametersHolder, BoardingSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.27
                    @Override // kotlin.jvm.functions.Function2
                    public final BoardingSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new BoardingSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory27 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BoardingSpinnerAdapter.class), null, anonymousClass27, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory27);
                new Pair(module, factoryInstanceFactory27);
                AnonymousClass28 anonymousClass28 = new Function2<Scope, ParametersHolder, DutyHeadSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.28
                    @Override // kotlin.jvm.functions.Function2
                    public final DutyHeadSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new DutyHeadSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory28 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DutyHeadSpinnerAdapter.class), null, anonymousClass28, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory28);
                new Pair(module, factoryInstanceFactory28);
                AnonymousClass29 anonymousClass29 = new Function2<Scope, ParametersHolder, FeePartialSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.29
                    @Override // kotlin.jvm.functions.Function2
                    public final FeePartialSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new FeePartialSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory29 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeePartialSpinnerAdapter.class), null, anonymousClass29, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory29);
                new Pair(module, factoryInstanceFactory29);
                AnonymousClass30 anonymousClass30 = new Function2<Scope, ParametersHolder, HostelLeaveTypeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.30
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelLeaveTypeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new HostelLeaveTypeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory30 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelLeaveTypeSpinnerAdapter.class), null, anonymousClass30, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory30);
                new Pair(module, factoryInstanceFactory30);
                AnonymousClass31 anonymousClass31 = new Function2<Scope, ParametersHolder, CurrentSemSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.31
                    @Override // kotlin.jvm.functions.Function2
                    public final CurrentSemSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CurrentSemSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory31 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CurrentSemSpinnerAdapter.class), null, anonymousClass31, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory31);
                new Pair(module, factoryInstanceFactory31);
                AnonymousClass32 anonymousClass32 = new Function2<Scope, ParametersHolder, CertificateIsHostlerSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.32
                    @Override // kotlin.jvm.functions.Function2
                    public final CertificateIsHostlerSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CertificateIsHostlerSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory32 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertificateIsHostlerSpinnerAdapter.class), null, anonymousClass32, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory32);
                new Pair(module, factoryInstanceFactory32);
                AnonymousClass33 anonymousClass33 = new Function2<Scope, ParametersHolder, AsietBoardingSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.33
                    @Override // kotlin.jvm.functions.Function2
                    public final AsietBoardingSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new AsietBoardingSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory33 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AsietBoardingSpinnerAdapter.class), null, anonymousClass33, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory33);
                new Pair(module, factoryInstanceFactory33);
                AnonymousClass34 anonymousClass34 = new Function2<Scope, ParametersHolder, ApplySubjectRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.34
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplySubjectRegistrationSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new ApplySubjectRegistrationSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory34 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplySubjectRegistrationSpinnerAdapter.class), null, anonymousClass34, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory34);
                new Pair(module, factoryInstanceFactory34);
                AnonymousClass35 anonymousClass35 = new Function2<Scope, ParametersHolder, SubjectRegSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.35
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRegSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new SubjectRegSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory35 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRegSpinnerAdapter.class), null, anonymousClass35, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory35);
                new Pair(module, factoryInstanceFactory35);
                AnonymousClass36 anonymousClass36 = new Function2<Scope, ParametersHolder, PathwaySpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.36
                    @Override // kotlin.jvm.functions.Function2
                    public final PathwaySpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new PathwaySpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory36 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PathwaySpinnerAdapter.class), null, anonymousClass36, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory36);
                new Pair(module, factoryInstanceFactory36);
                AnonymousClass37 anonymousClass37 = new Function2<Scope, ParametersHolder, PushAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.37
                    @Override // kotlin.jvm.functions.Function2
                    public final PushAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PushAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PushAdapter.class), null, anonymousClass37, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory);
                }
                new Pair(module, singleInstanceFactory);
                AnonymousClass38 anonymousClass38 = new Function2<Scope, ParametersHolder, UniversityResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.38
                    @Override // kotlin.jvm.functions.Function2
                    public final UniversityResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UniversityResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UniversityResultAdapter.class), null, anonymousClass38, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory2);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory2);
                }
                new Pair(module, singleInstanceFactory2);
                AnonymousClass39 anonymousClass39 = new Function2<Scope, ParametersHolder, InboxAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.39
                    @Override // kotlin.jvm.functions.Function2
                    public final InboxAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InboxAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InboxAdapter.class), null, anonymousClass39, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory3);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory3);
                }
                new Pair(module, singleInstanceFactory3);
                AnonymousClass40 anonymousClass40 = new Function2<Scope, ParametersHolder, SentItemAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.40
                    @Override // kotlin.jvm.functions.Function2
                    public final SentItemAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SentItemAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory4 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SentItemAdapter.class), null, anonymousClass40, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory4);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory4);
                }
                new Pair(module, singleInstanceFactory4);
                AnonymousClass41 anonymousClass41 = new Function2<Scope, ParametersHolder, DashboardAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.41
                    @Override // kotlin.jvm.functions.Function2
                    public final DashboardAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DashboardAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory37 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashboardAdapter.class), null, anonymousClass41, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory37);
                new Pair(module, factoryInstanceFactory37);
                AnonymousClass42 anonymousClass42 = new Function2<Scope, ParametersHolder, DashTimeTableAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.42
                    @Override // kotlin.jvm.functions.Function2
                    public final DashTimeTableAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new DashTimeTableAdapter((FragmentManager) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(FragmentManager.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory38 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashTimeTableAdapter.class), null, anonymousClass42, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory38);
                new Pair(module, factoryInstanceFactory38);
                AnonymousClass43 anonymousClass43 = new Function2<Scope, ParametersHolder, DashTableViewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.43
                    @Override // kotlin.jvm.functions.Function2
                    public final DashTableViewAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DashTableViewAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory39 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DashTableViewAdapter.class), null, anonymousClass43, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory39);
                new Pair(module, factoryInstanceFactory39);
                AnonymousClass44 anonymousClass44 = new Function2<Scope, ParametersHolder, TimeTableAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.44
                    @Override // kotlin.jvm.functions.Function2
                    public final TimeTableAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new TimeTableAdapter((FragmentManager) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(FragmentManager.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory40 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimeTableAdapter.class), null, anonymousClass44, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory40);
                new Pair(module, factoryInstanceFactory40);
                AnonymousClass45 anonymousClass45 = new Function2<Scope, ParametersHolder, TimetableViewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.45
                    @Override // kotlin.jvm.functions.Function2
                    public final TimetableViewAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TimetableViewAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory41 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimetableViewAdapter.class), null, anonymousClass45, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory41);
                new Pair(module, factoryInstanceFactory41);
                AnonymousClass46 anonymousClass46 = new Function2<Scope, ParametersHolder, ChangeInTimetableAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.46
                    @Override // kotlin.jvm.functions.Function2
                    public final ChangeInTimetableAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChangeInTimetableAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChangeInTimetableAdapter.class), null, anonymousClass46, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory5);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory5);
                }
                new Pair(module, singleInstanceFactory5);
                AnonymousClass47 anonymousClass47 = new Function2<Scope, ParametersHolder, SpecialClassAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.47
                    @Override // kotlin.jvm.functions.Function2
                    public final SpecialClassAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SpecialClassAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory6 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SpecialClassAdapter.class), null, anonymousClass47, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory6);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory6);
                }
                new Pair(module, singleInstanceFactory6);
                AnonymousClass48 anonymousClass48 = new Function2<Scope, ParametersHolder, NoticeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.48
                    @Override // kotlin.jvm.functions.Function2
                    public final NoticeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NoticeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NoticeAdapter.class), null, anonymousClass48, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory7);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory7);
                }
                new Pair(module, singleInstanceFactory7);
                AnonymousClass49 anonymousClass49 = new Function2<Scope, ParametersHolder, RemarkAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.49
                    @Override // kotlin.jvm.functions.Function2
                    public final RemarkAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RemarkAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory8 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RemarkAdapter.class), null, anonymousClass49, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory8);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory8);
                }
                new Pair(module, singleInstanceFactory8);
                AnonymousClass50 anonymousClass50 = new Function2<Scope, ParametersHolder, ExamAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.50
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory9 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamAdapter.class), null, anonymousClass50, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory9);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory9);
                }
                new Pair(module, singleInstanceFactory9);
                AnonymousClass51 anonymousClass51 = new Function2<Scope, ParametersHolder, CircularAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.51
                    @Override // kotlin.jvm.functions.Function2
                    public final CircularAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CircularAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory10 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CircularAdapter.class), null, anonymousClass51, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory10);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory10);
                }
                new Pair(module, singleInstanceFactory10);
                AnonymousClass52 anonymousClass52 = new Function2<Scope, ParametersHolder, PlacementAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.52
                    @Override // kotlin.jvm.functions.Function2
                    public final PlacementAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PlacementAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory11 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PlacementAdapter.class), null, anonymousClass52, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory11);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory11);
                }
                new Pair(module, singleInstanceFactory11);
                AnonymousClass53 anonymousClass53 = new Function2<Scope, ParametersHolder, PalaiHostelAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.53
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiHostelAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiHostelAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory12 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiHostelAdapter.class), null, anonymousClass53, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory12);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory12);
                }
                new Pair(module, singleInstanceFactory12);
                AnonymousClass54 anonymousClass54 = new Function2<Scope, ParametersHolder, TutorialResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.54
                    @Override // kotlin.jvm.functions.Function2
                    public final TutorialResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TutorialResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory13 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialResultAdapter.class), null, anonymousClass54, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory13);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory13);
                }
                new Pair(module, singleInstanceFactory13);
                AnonymousClass55 anonymousClass55 = new Function2<Scope, ParametersHolder, SubjectAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.55
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory14 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectAdapter.class), null, anonymousClass55, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory14);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory14);
                }
                new Pair(module, singleInstanceFactory14);
                AnonymousClass56 anonymousClass56 = new Function2<Scope, ParametersHolder, SyllabusAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.56
                    @Override // kotlin.jvm.functions.Function2
                    public final SyllabusAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SyllabusAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory15 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SyllabusAdapter.class), null, anonymousClass56, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory15);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory15);
                }
                new Pair(module, singleInstanceFactory15);
                AnonymousClass57 anonymousClass57 = new Function2<Scope, ParametersHolder, CoAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.57
                    @Override // kotlin.jvm.functions.Function2
                    public final CoAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CoAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory16 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CoAdapter.class), null, anonymousClass57, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory16);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory16);
                }
                new Pair(module, singleInstanceFactory16);
                AnonymousClass58 anonymousClass58 = new Function2<Scope, ParametersHolder, TeacherAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.58
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory17 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherAdapter.class), null, anonymousClass58, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory17);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory17);
                }
                new Pair(module, singleInstanceFactory17);
                AnonymousClass59 anonymousClass59 = new Function2<Scope, ParametersHolder, OnlineClassAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.59
                    @Override // kotlin.jvm.functions.Function2
                    public final OnlineClassAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OnlineClassAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory18 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OnlineClassAdapter.class), null, anonymousClass59, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory18);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory18);
                }
                new Pair(module, singleInstanceFactory18);
                AnonymousClass60 anonymousClass60 = new Function2<Scope, ParametersHolder, VideoClassAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.60
                    @Override // kotlin.jvm.functions.Function2
                    public final VideoClassAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new VideoClassAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory42 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VideoClassAdapter.class), null, anonymousClass60, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory42);
                new Pair(module, factoryInstanceFactory42);
                AnonymousClass61 anonymousClass61 = new Function2<Scope, ParametersHolder, AttendanceAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.61
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory19 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceAdapter.class), null, anonymousClass61, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory19);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory19);
                }
                new Pair(module, singleInstanceFactory19);
                AnonymousClass62 anonymousClass62 = new Function2<Scope, ParametersHolder, LabDueAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.62
                    @Override // kotlin.jvm.functions.Function2
                    public final LabDueAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabDueAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory20 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabDueAdapter.class), null, anonymousClass62, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory20);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory20);
                }
                new Pair(module, singleInstanceFactory20);
                AnonymousClass63 anonymousClass63 = new Function2<Scope, ParametersHolder, LabListAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.63
                    @Override // kotlin.jvm.functions.Function2
                    public final LabListAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabListAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory21 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabListAdapter.class), null, anonymousClass63, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory21);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory21);
                }
                new Pair(module, singleInstanceFactory21);
                AnonymousClass64 anonymousClass64 = new Function2<Scope, ParametersHolder, EquipmentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.64
                    @Override // kotlin.jvm.functions.Function2
                    public final EquipmentAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new EquipmentAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory22 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EquipmentAdapter.class), null, anonymousClass64, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory22);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory22);
                }
                new Pair(module, singleInstanceFactory22);
                AnonymousClass65 anonymousClass65 = new Function2<Scope, ParametersHolder, SafetyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.65
                    @Override // kotlin.jvm.functions.Function2
                    public final SafetyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SafetyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory23 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SafetyAdapter.class), null, anonymousClass65, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory23);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory23);
                }
                new Pair(module, singleInstanceFactory23);
                AnonymousClass66 anonymousClass66 = new Function2<Scope, ParametersHolder, LabPracticalAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.66
                    @Override // kotlin.jvm.functions.Function2
                    public final LabPracticalAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LabPracticalAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory24 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LabPracticalAdapter.class), null, anonymousClass66, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory24);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory24);
                }
                new Pair(module, singleInstanceFactory24);
                AnonymousClass67 anonymousClass67 = new Function2<Scope, ParametersHolder, ExperimentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.67
                    @Override // kotlin.jvm.functions.Function2
                    public final ExperimentAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExperimentAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory25 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExperimentAdapter.class), null, anonymousClass67, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory25);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory25);
                }
                new Pair(module, singleInstanceFactory25);
                AnonymousClass68 anonymousClass68 = new Function2<Scope, ParametersHolder, EvaluationAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.68
                    @Override // kotlin.jvm.functions.Function2
                    public final EvaluationAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new EvaluationAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory26 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EvaluationAdapter.class), null, anonymousClass68, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory26);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory26);
                }
                new Pair(module, singleInstanceFactory26);
                AnonymousClass69 anonymousClass69 = new Function2<Scope, ParametersHolder, ChatAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.69
                    @Override // kotlin.jvm.functions.Function2
                    public final ChatAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ChatAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory27 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatAdapter.class), null, anonymousClass69, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory27);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory27);
                }
                new Pair(module, singleInstanceFactory27);
                AnonymousClass70 anonymousClass70 = new Function2<Scope, ParametersHolder, CommentReplyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.70
                    @Override // kotlin.jvm.functions.Function2
                    public final CommentReplyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CommentReplyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory28 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CommentReplyAdapter.class), null, anonymousClass70, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory28);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory28);
                }
                new Pair(module, singleInstanceFactory28);
                AnonymousClass71 anonymousClass71 = new Function2<Scope, ParametersHolder, CommentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.71
                    @Override // kotlin.jvm.functions.Function2
                    public final CommentAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CommentAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory29 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CommentAdapter.class), null, anonymousClass71, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory29);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory29);
                }
                new Pair(module, singleInstanceFactory29);
                AnonymousClass72 anonymousClass72 = new Function2<Scope, ParametersHolder, ProofDutyLeaveAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.72
                    @Override // kotlin.jvm.functions.Function2
                    public final ProofDutyLeaveAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProofDutyLeaveAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory30 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProofDutyLeaveAdapter.class), null, anonymousClass72, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory30);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory30);
                }
                new Pair(module, singleInstanceFactory30);
                AnonymousClass73 anonymousClass73 = new Function2<Scope, ParametersHolder, ResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.73
                    @Override // kotlin.jvm.functions.Function2
                    public final ResultAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new ResultAdapter((FragmentManager) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(FragmentManager.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory43 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResultAdapter.class), null, anonymousClass73, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory43);
                new Pair(module, factoryInstanceFactory43);
                AnonymousClass74 anonymousClass74 = new Function2<Scope, ParametersHolder, AssignmentResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.74
                    @Override // kotlin.jvm.functions.Function2
                    public final AssignmentResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AssignmentResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory31 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AssignmentResultAdapter.class), null, anonymousClass74, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory31);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory31);
                }
                new Pair(module, singleInstanceFactory31);
                AnonymousClass75 anonymousClass75 = new Function2<Scope, ParametersHolder, SessionalAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.75
                    @Override // kotlin.jvm.functions.Function2
                    public final SessionalAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SessionalAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory32 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SessionalAdapter.class), null, anonymousClass75, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory32);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory32);
                }
                new Pair(module, singleInstanceFactory32);
                AnonymousClass76 anonymousClass76 = new Function2<Scope, ParametersHolder, ResultModuleTestAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.76
                    @Override // kotlin.jvm.functions.Function2
                    public final ResultModuleTestAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ResultModuleTestAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory33 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ResultModuleTestAdapter.class), null, anonymousClass76, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory33);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory33);
                }
                new Pair(module, singleInstanceFactory33);
                AnonymousClass77 anonymousClass77 = new Function2<Scope, ParametersHolder, InternalResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.77
                    @Override // kotlin.jvm.functions.Function2
                    public final InternalResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InternalResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory34 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternalResultAdapter.class), null, anonymousClass77, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory34);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory34);
                }
                new Pair(module, singleInstanceFactory34);
                AnonymousClass78 anonymousClass78 = new Function2<Scope, ParametersHolder, UniversityExamAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.78
                    @Override // kotlin.jvm.functions.Function2
                    public final UniversityExamAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UniversityExamAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory44 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UniversityExamAdapter.class), null, anonymousClass78, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory44);
                new Pair(module, factoryInstanceFactory44);
                AnonymousClass79 anonymousClass79 = new Function2<Scope, ParametersHolder, UnivInitialPageAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.79
                    @Override // kotlin.jvm.functions.Function2
                    public final UnivInitialPageAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UnivInitialPageAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory35 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UnivInitialPageAdapter.class), null, anonymousClass79, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory35);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory35);
                }
                new Pair(module, singleInstanceFactory35);
                AnonymousClass80 anonymousClass80 = new Function2<Scope, ParametersHolder, SemListAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.80
                    @Override // kotlin.jvm.functions.Function2
                    public final SemListAdapter invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemListAdapter();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory45 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemListAdapter.class), null, anonymousClass80, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory45);
                new Pair(module, factoryInstanceFactory45);
                AnonymousClass81 anonymousClass81 = new Function2<Scope, ParametersHolder, SemListAdapterTwo>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.81
                    @Override // kotlin.jvm.functions.Function2
                    public final SemListAdapterTwo invoke(Scope factory, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemListAdapterTwo();
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory46 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemListAdapterTwo.class), null, anonymousClass81, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory46);
                new Pair(module, factoryInstanceFactory46);
                AnonymousClass82 anonymousClass82 = new Function2<Scope, ParametersHolder, LeaveAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.82
                    @Override // kotlin.jvm.functions.Function2
                    public final LeaveAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new LeaveAdapter((FragmentManager) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(FragmentManager.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory47 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveAdapter.class), null, anonymousClass82, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory47);
                new Pair(module, factoryInstanceFactory47);
                AnonymousClass83 anonymousClass83 = new Function2<Scope, ParametersHolder, MedicalAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.83
                    @Override // kotlin.jvm.functions.Function2
                    public final MedicalAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MedicalAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory36 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MedicalAdapter.class), null, anonymousClass83, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory36);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory36);
                }
                new Pair(module, singleInstanceFactory36);
                AnonymousClass84 anonymousClass84 = new Function2<Scope, ParametersHolder, DutyLeaveAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.84
                    @Override // kotlin.jvm.functions.Function2
                    public final DutyLeaveAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DutyLeaveAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory37 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DutyLeaveAdapter.class), null, anonymousClass84, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory37);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory37);
                }
                new Pair(module, singleInstanceFactory37);
                AnonymousClass85 anonymousClass85 = new Function2<Scope, ParametersHolder, MaterialAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.85
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaterialAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory38 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialAdapter.class), null, anonymousClass85, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory38);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory38);
                }
                new Pair(module, singleInstanceFactory38);
                AnonymousClass86 anonymousClass86 = new Function2<Scope, ParametersHolder, QuestionBankAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.86
                    @Override // kotlin.jvm.functions.Function2
                    public final QuestionBankAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuestionBankAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory39 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuestionBankAdapter.class), null, anonymousClass86, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory39);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory39);
                }
                new Pair(module, singleInstanceFactory39);
                AnonymousClass87 anonymousClass87 = new Function2<Scope, ParametersHolder, SeriesAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.87
                    @Override // kotlin.jvm.functions.Function2
                    public final SeriesAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SeriesAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory40 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SeriesAdapter.class), null, anonymousClass87, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory40);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory40);
                }
                new Pair(module, singleInstanceFactory40);
                AnonymousClass88 anonymousClass88 = new Function2<Scope, ParametersHolder, ModuleTestAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.88
                    @Override // kotlin.jvm.functions.Function2
                    public final ModuleTestAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ModuleTestAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory41 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ModuleTestAdapter.class), null, anonymousClass88, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory41);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory41);
                }
                new Pair(module, singleInstanceFactory41);
                AnonymousClass89 anonymousClass89 = new Function2<Scope, ParametersHolder, QuestionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.89
                    @Override // kotlin.jvm.functions.Function2
                    public final QuestionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuestionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory42 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuestionAdapter.class), null, anonymousClass89, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory42);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory42);
                }
                new Pair(module, singleInstanceFactory42);
                AnonymousClass90 anonymousClass90 = new Function2<Scope, ParametersHolder, AssignmentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.90
                    @Override // kotlin.jvm.functions.Function2
                    public final AssignmentAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AssignmentAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory43 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AssignmentAdapter.class), null, anonymousClass90, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory43);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory43);
                }
                new Pair(module, singleInstanceFactory43);
                AnonymousClass91 anonymousClass91 = new Function2<Scope, ParametersHolder, SemRegisterListAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.91
                    @Override // kotlin.jvm.functions.Function2
                    public final SemRegisterListAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SemRegisterListAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory44 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SemRegisterListAdapter.class), null, anonymousClass91, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory44);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory44);
                }
                new Pair(module, singleInstanceFactory44);
                AnonymousClass92 anonymousClass92 = new Function2<Scope, ParametersHolder, CentralizedInfoAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.92
                    @Override // kotlin.jvm.functions.Function2
                    public final CentralizedInfoAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CentralizedInfoAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory45 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CentralizedInfoAdapter.class), null, anonymousClass92, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory45);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory45);
                }
                new Pair(module, singleInstanceFactory45);
                AnonymousClass93 anonymousClass93 = new Function2<Scope, ParametersHolder, LiveTvAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.93
                    @Override // kotlin.jvm.functions.Function2
                    public final LiveTvAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LiveTvAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory46 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LiveTvAdapter.class), null, anonymousClass93, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory46);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory46);
                }
                new Pair(module, singleInstanceFactory46);
                AnonymousClass94 anonymousClass94 = new Function2<Scope, ParametersHolder, TutorialAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.94
                    @Override // kotlin.jvm.functions.Function2
                    public final TutorialAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TutorialAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory47 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialAdapter.class), null, anonymousClass94, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory47);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory47);
                }
                new Pair(module, singleInstanceFactory47);
                AnonymousClass95 anonymousClass95 = new Function2<Scope, ParametersHolder, HomeWorkAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.95
                    @Override // kotlin.jvm.functions.Function2
                    public final HomeWorkAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HomeWorkAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory48 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeWorkAdapter.class), null, anonymousClass95, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory48);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory48);
                }
                new Pair(module, singleInstanceFactory48);
                AnonymousClass96 anonymousClass96 = new Function2<Scope, ParametersHolder, HomeWorkFilesAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.96
                    @Override // kotlin.jvm.functions.Function2
                    public final HomeWorkFilesAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HomeWorkFilesAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory49 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeWorkFilesAdapter.class), null, anonymousClass96, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory49);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory49);
                }
                new Pair(module, singleInstanceFactory49);
                AnonymousClass97 anonymousClass97 = new Function2<Scope, ParametersHolder, FeeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.97
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory50 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeAdapter.class), null, anonymousClass97, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory50);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory50);
                }
                new Pair(module, singleInstanceFactory50);
                AnonymousClass98 anonymousClass98 = new Function2<Scope, ParametersHolder, ReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.98
                    @Override // kotlin.jvm.functions.Function2
                    public final ReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory51 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReceiptAdapter.class), null, anonymousClass98, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory51);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory51);
                }
                new Pair(module, singleInstanceFactory51);
                AnonymousClass99 anonymousClass99 = new Function2<Scope, ParametersHolder, DueAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.99
                    @Override // kotlin.jvm.functions.Function2
                    public final DueAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DueAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory52 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DueAdapter.class), null, anonymousClass99, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory52);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory52);
                }
                new Pair(module, singleInstanceFactory52);
                AnonymousClass100 anonymousClass100 = new Function2<Scope, ParametersHolder, DuePayAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.100
                    @Override // kotlin.jvm.functions.Function2
                    public final DuePayAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DuePayAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory53 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DuePayAdapter.class), null, anonymousClass100, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory53);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory53);
                }
                new Pair(module, singleInstanceFactory53);
                AnonymousClass101 anonymousClass101 = new Function2<Scope, ParametersHolder, ActivityPointAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.101
                    @Override // kotlin.jvm.functions.Function2
                    public final ActivityPointAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ActivityPointAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory54 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ActivityPointAdapter.class), null, anonymousClass101, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory54);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory54);
                }
                new Pair(module, singleInstanceFactory54);
                AnonymousClass102 anonymousClass102 = new Function2<Scope, ParametersHolder, ManageActivityAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.102
                    @Override // kotlin.jvm.functions.Function2
                    public final ManageActivityAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ManageActivityAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory55 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ManageActivityAdapter.class), null, anonymousClass102, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory55);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory55);
                }
                new Pair(module, singleInstanceFactory55);
                AnonymousClass103 anonymousClass103 = new Function2<Scope, ParametersHolder, SubjectCoverageAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.103
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectCoverageAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectCoverageAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory56 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectCoverageAdapter.class), null, anonymousClass103, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory56);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory56);
                }
                new Pair(module, singleInstanceFactory56);
                AnonymousClass104 anonymousClass104 = new Function2<Scope, ParametersHolder, GrievanceAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.104
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GrievanceAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory57 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceAdapter.class), null, anonymousClass104, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory57);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory57);
                }
                new Pair(module, singleInstanceFactory57);
                AnonymousClass105 anonymousClass105 = new Function2<Scope, ParametersHolder, ActionsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.105
                    @Override // kotlin.jvm.functions.Function2
                    public final ActionsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ActionsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory58 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ActionsAdapter.class), null, anonymousClass105, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory58);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory58);
                }
                new Pair(module, singleInstanceFactory58);
                AnonymousClass106 anonymousClass106 = new Function2<Scope, ParametersHolder, CellMemberAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.106
                    @Override // kotlin.jvm.functions.Function2
                    public final CellMemberAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CellMemberAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory59 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CellMemberAdapter.class), null, anonymousClass106, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory59);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory59);
                }
                new Pair(module, singleInstanceFactory59);
                AnonymousClass107 anonymousClass107 = new Function2<Scope, ParametersHolder, GrievanceDocAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.107
                    @Override // kotlin.jvm.functions.Function2
                    public final GrievanceDocAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GrievanceDocAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory60 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GrievanceDocAdapter.class), null, anonymousClass107, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory60);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory60);
                }
                new Pair(module, singleInstanceFactory60);
                AnonymousClass108 anonymousClass108 = new Function2<Scope, ParametersHolder, CertificateRequestAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.108
                    @Override // kotlin.jvm.functions.Function2
                    public final CertificateRequestAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CertificateRequestAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory61 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertificateRequestAdapter.class), null, anonymousClass108, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory61);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory61);
                }
                new Pair(module, singleInstanceFactory61);
                AnonymousClass109 anonymousClass109 = new Function2<Scope, ParametersHolder, CounsellingAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.109
                    @Override // kotlin.jvm.functions.Function2
                    public final CounsellingAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CounsellingAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory62 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounsellingAdapter.class), null, anonymousClass109, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory62);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory62);
                }
                new Pair(module, singleInstanceFactory62);
                AnonymousClass110 anonymousClass110 = new Function2<Scope, ParametersHolder, Actions2Adapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.110
                    @Override // kotlin.jvm.functions.Function2
                    public final Actions2Adapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new Actions2Adapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory63 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Actions2Adapter.class), null, anonymousClass110, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory63);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory63);
                }
                new Pair(module, singleInstanceFactory63);
                AnonymousClass111 anonymousClass111 = new Function2<Scope, ParametersHolder, CellMember2Adapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.111
                    @Override // kotlin.jvm.functions.Function2
                    public final CellMember2Adapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CellMember2Adapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory64 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CellMember2Adapter.class), null, anonymousClass111, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory64);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory64);
                }
                new Pair(module, singleInstanceFactory64);
                AnonymousClass112 anonymousClass112 = new Function2<Scope, ParametersHolder, InternshipAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.112
                    @Override // kotlin.jvm.functions.Function2
                    public final InternshipAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new InternshipAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory65 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InternshipAdapter.class), null, anonymousClass112, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory65);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory65);
                }
                new Pair(module, singleInstanceFactory65);
                AnonymousClass113 anonymousClass113 = new Function2<Scope, ParametersHolder, HostelMonthAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.113
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelMonthAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelMonthAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory66 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelMonthAdapter.class), null, anonymousClass113, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory66);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory66);
                }
                new Pair(module, singleInstanceFactory66);
                AnonymousClass114 anonymousClass114 = new Function2<Scope, ParametersHolder, HostelFeesAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.114
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelFeesAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelFeesAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory67 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelFeesAdapter.class), null, anonymousClass114, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory67);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory67);
                }
                new Pair(module, singleInstanceFactory67);
                AnonymousClass115 anonymousClass115 = new Function2<Scope, ParametersHolder, TkmReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.115
                    @Override // kotlin.jvm.functions.Function2
                    public final TkmReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TkmReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory68 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TkmReceiptAdapter.class), null, anonymousClass115, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory68);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory68);
                }
                new Pair(module, singleInstanceFactory68);
                AnonymousClass116 anonymousClass116 = new Function2<Scope, ParametersHolder, StoreAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.116
                    @Override // kotlin.jvm.functions.Function2
                    public final StoreAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new StoreAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory69 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StoreAdapter.class), null, anonymousClass116, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory69);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory69);
                }
                new Pair(module, singleInstanceFactory69);
                AnonymousClass117 anonymousClass117 = new Function2<Scope, ParametersHolder, FeeEngineerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.117
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeEngineerAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeEngineerAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory70 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeEngineerAdapter.class), null, anonymousClass117, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory70);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory70);
                }
                new Pair(module, singleInstanceFactory70);
                AnonymousClass118 anonymousClass118 = new Function2<Scope, ParametersHolder, FeeArtsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.118
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeArtsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeArtsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory71 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeArtsAdapter.class), null, anonymousClass118, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory71);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory71);
                }
                new Pair(module, singleInstanceFactory71);
                AnonymousClass119 anonymousClass119 = new Function2<Scope, ParametersHolder, PalaiSemesterRegAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.119
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiSemesterRegAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiSemesterRegAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory72 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiSemesterRegAdapter.class), null, anonymousClass119, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory72);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory72);
                }
                new Pair(module, singleInstanceFactory72);
                AnonymousClass120 anonymousClass120 = new Function2<Scope, ParametersHolder, FeeDetailAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.120
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeDetailAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeDetailAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory73 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeDetailAdapter.class), null, anonymousClass120, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory73);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory73);
                }
                new Pair(module, singleInstanceFactory73);
                AnonymousClass121 anonymousClass121 = new Function2<Scope, ParametersHolder, ProgramOutcomeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.121
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramOutcomeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramOutcomeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory74 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramOutcomeAdapter.class), null, anonymousClass121, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory74);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory74);
                }
                new Pair(module, singleInstanceFactory74);
                AnonymousClass122 anonymousClass122 = new Function2<Scope, ParametersHolder, ProgramEducationalAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.122
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramEducationalAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramEducationalAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory75 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramEducationalAdapter.class), null, anonymousClass122, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory75);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory75);
                }
                new Pair(module, singleInstanceFactory75);
                AnonymousClass123 anonymousClass123 = new Function2<Scope, ParametersHolder, ProgramSpecificAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.123
                    @Override // kotlin.jvm.functions.Function2
                    public final ProgramSpecificAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ProgramSpecificAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory76 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProgramSpecificAdapter.class), null, anonymousClass123, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory76);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory76);
                }
                new Pair(module, singleInstanceFactory76);
                AnonymousClass124 anonymousClass124 = new Function2<Scope, ParametersHolder, RegistrationAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.124
                    @Override // kotlin.jvm.functions.Function2
                    public final RegistrationAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RegistrationAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory77 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RegistrationAdapter.class), null, anonymousClass124, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory77);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory77);
                }
                new Pair(module, singleInstanceFactory77);
                AnonymousClass125 anonymousClass125 = new Function2<Scope, ParametersHolder, LeaveManagementAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.125
                    @Override // kotlin.jvm.functions.Function2
                    public final LeaveManagementAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new LeaveManagementAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory78 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveManagementAdapter.class), null, anonymousClass125, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory78);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory78);
                }
                new Pair(module, singleInstanceFactory78);
                AnonymousClass126 anonymousClass126 = new Function2<Scope, ParametersHolder, NoticeMainAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.126
                    @Override // kotlin.jvm.functions.Function2
                    public final NoticeMainAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NoticeMainAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory79 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NoticeMainAdapter.class), null, anonymousClass126, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory79);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory79);
                }
                new Pair(module, singleInstanceFactory79);
                AnonymousClass127 anonymousClass127 = new Function2<Scope, ParametersHolder, CertificateTypeSpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.127
                    @Override // kotlin.jvm.functions.Function2
                    public final CertificateTypeSpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CertificateTypeSpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory48 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertificateTypeSpinnerAdapter.class), null, anonymousClass127, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory48);
                new Pair(module, factoryInstanceFactory48);
                AnonymousClass128 anonymousClass128 = new Function2<Scope, ParametersHolder, CertioficateType2SpinnerAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.128
                    @Override // kotlin.jvm.functions.Function2
                    public final CertioficateType2SpinnerAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new CertioficateType2SpinnerAdapter((AppCompatActivity) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(AppCompatActivity.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory49 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CertioficateType2SpinnerAdapter.class), null, anonymousClass128, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory49);
                new Pair(module, factoryInstanceFactory49);
                AnonymousClass129 anonymousClass129 = new Function2<Scope, ParametersHolder, ExamViewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.129
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamViewAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamViewAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory80 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamViewAdapter.class), null, anonymousClass129, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory80);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory80);
                }
                new Pair(module, singleInstanceFactory80);
                AnonymousClass130 anonymousClass130 = new Function2<Scope, ParametersHolder, ExamSubjectAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.130
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamSubjectAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamSubjectAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory81 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamSubjectAdapter.class), null, anonymousClass130, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory81);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory81);
                }
                new Pair(module, singleInstanceFactory81);
                AnonymousClass131 anonymousClass131 = new Function2<Scope, ParametersHolder, ExamSubjectAdapter2>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.131
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamSubjectAdapter2 invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamSubjectAdapter2();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory82 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamSubjectAdapter2.class), null, anonymousClass131, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory82);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory82);
                }
                new Pair(module, singleInstanceFactory82);
                AnonymousClass132 anonymousClass132 = new Function2<Scope, ParametersHolder, ExamSubjectAdapter3>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.132
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamSubjectAdapter3 invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamSubjectAdapter3();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory83 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamSubjectAdapter3.class), null, anonymousClass132, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory83);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory83);
                }
                new Pair(module, singleInstanceFactory83);
                AnonymousClass133 anonymousClass133 = new Function2<Scope, ParametersHolder, ExamRegisterAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.133
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamRegisterAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamRegisterAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory84 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamRegisterAdapter.class), null, anonymousClass133, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory84);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory84);
                }
                new Pair(module, singleInstanceFactory84);
                AnonymousClass134 anonymousClass134 = new Function2<Scope, ParametersHolder, UpdateRegisterAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.134
                    @Override // kotlin.jvm.functions.Function2
                    public final UpdateRegisterAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new UpdateRegisterAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory85 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UpdateRegisterAdapter.class), null, anonymousClass134, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory85);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory85);
                }
                new Pair(module, singleInstanceFactory85);
                AnonymousClass135 anonymousClass135 = new Function2<Scope, ParametersHolder, ExamReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.135
                    @Override // kotlin.jvm.functions.Function2
                    public final ExamReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ExamReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory86 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExamReceiptAdapter.class), null, anonymousClass135, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory86);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory86);
                }
                new Pair(module, singleInstanceFactory86);
                AnonymousClass136 anonymousClass136 = new Function2<Scope, ParametersHolder, RevaluationAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.136
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory87 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationAdapter.class), null, anonymousClass136, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory87);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory87);
                }
                new Pair(module, singleInstanceFactory87);
                AnonymousClass137 anonymousClass137 = new Function2<Scope, ParametersHolder, RevaluationFeeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.137
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationFeeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationFeeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory88 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationFeeAdapter.class), null, anonymousClass137, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory88);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory88);
                }
                new Pair(module, singleInstanceFactory88);
                AnonymousClass138 anonymousClass138 = new Function2<Scope, ParametersHolder, RevaluationViewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.138
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationViewAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationViewAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory89 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationViewAdapter.class), null, anonymousClass138, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory89);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory89);
                }
                new Pair(module, singleInstanceFactory89);
                AnonymousClass139 anonymousClass139 = new Function2<Scope, ParametersHolder, RevaluationReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.139
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory90 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationReceiptAdapter.class), null, anonymousClass139, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory90);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory90);
                }
                new Pair(module, singleInstanceFactory90);
                AnonymousClass140 anonymousClass140 = new Function2<Scope, ParametersHolder, RevaluationUpdateAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.140
                    @Override // kotlin.jvm.functions.Function2
                    public final RevaluationUpdateAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RevaluationUpdateAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory91 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RevaluationUpdateAdapter.class), null, anonymousClass140, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory91);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory91);
                }
                new Pair(module, singleInstanceFactory91);
                AnonymousClass141 anonymousClass141 = new Function2<Scope, ParametersHolder, MessAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.141
                    @Override // kotlin.jvm.functions.Function2
                    public final MessAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MessAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory92 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MessAdapter.class), null, anonymousClass141, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory92);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory92);
                }
                new Pair(module, singleInstanceFactory92);
                AnonymousClass142 anonymousClass142 = new Function2<Scope, ParametersHolder, OrderHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.142
                    @Override // kotlin.jvm.functions.Function2
                    public final OrderHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OrderHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory93 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OrderHistoryAdapter.class), null, anonymousClass142, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory93);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory93);
                }
                new Pair(module, singleInstanceFactory93);
                AnonymousClass143 anonymousClass143 = new Function2<Scope, ParametersHolder, TransportFeeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.143
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportFeeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportFeeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory94 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportFeeAdapter.class), null, anonymousClass143, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory94);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory94);
                }
                new Pair(module, singleInstanceFactory94);
                AnonymousClass144 anonymousClass144 = new Function2<Scope, ParametersHolder, TransportReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.144
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory95 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportReceiptAdapter.class), null, anonymousClass144, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory95);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory95);
                }
                new Pair(module, singleInstanceFactory95);
                AnonymousClass145 anonymousClass145 = new Function2<Scope, ParametersHolder, CollegeListAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.145
                    @Override // kotlin.jvm.functions.Function2
                    public final CollegeListAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CollegeListAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory96 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CollegeListAdapter.class), null, anonymousClass145, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory96);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory96);
                }
                new Pair(module, singleInstanceFactory96);
                AnonymousClass146 anonymousClass146 = new Function2<Scope, ParametersHolder, PalaiHostelAdmissionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.146
                    @Override // kotlin.jvm.functions.Function2
                    public final PalaiHostelAdmissionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PalaiHostelAdmissionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory97 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PalaiHostelAdmissionAdapter.class), null, anonymousClass146, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory97);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory97);
                }
                new Pair(module, singleInstanceFactory97);
                AnonymousClass147 anonymousClass147 = new Function2<Scope, ParametersHolder, BookAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.147
                    @Override // kotlin.jvm.functions.Function2
                    public final BookAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory98 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookAdapter.class), null, anonymousClass147, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory98);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory98);
                }
                new Pair(module, singleInstanceFactory98);
                AnonymousClass148 anonymousClass148 = new Function2<Scope, ParametersHolder, BookRecordAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.148
                    @Override // kotlin.jvm.functions.Function2
                    public final BookRecordAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookRecordAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory99 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookRecordAdapter.class), null, anonymousClass148, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory99);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory99);
                }
                new Pair(module, singleInstanceFactory99);
                AnonymousClass149 anonymousClass149 = new Function2<Scope, ParametersHolder, in.etuwa.app.ui.transport.payment.TransportFeeAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.149
                    @Override // kotlin.jvm.functions.Function2
                    public final in.etuwa.app.ui.transport.payment.TransportFeeAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new in.etuwa.app.ui.transport.payment.TransportFeeAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory100 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(in.etuwa.app.ui.transport.payment.TransportFeeAdapter.class), null, anonymousClass149, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory100);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory100);
                }
                new Pair(module, singleInstanceFactory100);
                AnonymousClass150 anonymousClass150 = new Function2<Scope, ParametersHolder, TransportRegHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.150
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportRegHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportRegHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory101 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportRegHistoryAdapter.class), null, anonymousClass150, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory101);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory101);
                }
                new Pair(module, singleInstanceFactory101);
                AnonymousClass151 anonymousClass151 = new Function2<Scope, ParametersHolder, FeeMedicalAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.151
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeMedicalAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeMedicalAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory102 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeMedicalAdapter.class), null, anonymousClass151, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory102);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory102);
                }
                new Pair(module, singleInstanceFactory102);
                AnonymousClass152 anonymousClass152 = new Function2<Scope, ParametersHolder, DirectApplyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.152
                    @Override // kotlin.jvm.functions.Function2
                    public final DirectApplyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DirectApplyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory103 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DirectApplyAdapter.class), null, anonymousClass152, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory103);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory103);
                }
                new Pair(module, singleInstanceFactory103);
                AnonymousClass153 anonymousClass153 = new Function2<Scope, ParametersHolder, FeeListAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.153
                    @Override // kotlin.jvm.functions.Function2
                    public final FeeListAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new FeeListAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory104 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FeeListAdapter.class), null, anonymousClass153, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory104);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory104);
                }
                new Pair(module, singleInstanceFactory104);
                AnonymousClass154 anonymousClass154 = new Function2<Scope, ParametersHolder, HostelPartialMonthlyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.154
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPartialMonthlyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelPartialMonthlyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory105 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPartialMonthlyAdapter.class), null, anonymousClass154, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory105);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory105);
                }
                new Pair(module, singleInstanceFactory105);
                AnonymousClass155 anonymousClass155 = new Function2<Scope, ParametersHolder, HostelPartialAdmissionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.155
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPartialAdmissionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelPartialAdmissionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory106 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPartialAdmissionAdapter.class), null, anonymousClass155, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory106);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory106);
                }
                new Pair(module, singleInstanceFactory106);
                AnonymousClass156 anonymousClass156 = new Function2<Scope, ParametersHolder, HostelPartialEditAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.156
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelPartialEditAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelPartialEditAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory107 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelPartialEditAdapter.class), null, anonymousClass156, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory107);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory107);
                }
                new Pair(module, singleInstanceFactory107);
                AnonymousClass157 anonymousClass157 = new Function2<Scope, ParametersHolder, HostelViewLeaveAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.157
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelViewLeaveAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelViewLeaveAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory108 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelViewLeaveAdapter.class), null, anonymousClass157, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory108);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory108);
                }
                new Pair(module, singleInstanceFactory108);
                AnonymousClass158 anonymousClass158 = new Function2<Scope, ParametersHolder, HostelAttendanceParentAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.158
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelAttendanceParentAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelAttendanceParentAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory109 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelAttendanceParentAdapter.class), null, anonymousClass158, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory109);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory109);
                }
                new Pair(module, singleInstanceFactory109);
                AnonymousClass159 anonymousClass159 = new Function2<Scope, ParametersHolder, DateAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.159
                    @Override // kotlin.jvm.functions.Function2
                    public final DateAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DateAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory110 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DateAdapter.class), null, anonymousClass159, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory110);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory110);
                }
                new Pair(module, singleInstanceFactory110);
                AnonymousClass160 anonymousClass160 = new Function2<Scope, ParametersHolder, HourAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.160
                    @Override // kotlin.jvm.functions.Function2
                    public final HourAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HourAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory111 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HourAdapter.class), null, anonymousClass160, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory111);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory111);
                }
                new Pair(module, singleInstanceFactory111);
                AnonymousClass161 anonymousClass161 = new Function2<Scope, ParametersHolder, MaterialDownloadAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.161
                    @Override // kotlin.jvm.functions.Function2
                    public final MaterialDownloadAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new MaterialDownloadAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory112 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MaterialDownloadAdapter.class), null, anonymousClass161, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory112);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory112);
                }
                new Pair(module, singleInstanceFactory112);
                AnonymousClass162 anonymousClass162 = new Function2<Scope, ParametersHolder, DayWiseTimeTableAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.162
                    @Override // kotlin.jvm.functions.Function2
                    public final DayWiseTimeTableAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new DayWiseTimeTableAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory113 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DayWiseTimeTableAdapter.class), null, anonymousClass162, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory113);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory113);
                }
                new Pair(module, singleInstanceFactory113);
                AnonymousClass163 anonymousClass163 = new Function2<Scope, ParametersHolder, SubjectPlanAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.163
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectPlanAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectPlanAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory114 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectPlanAdapter.class), null, anonymousClass163, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory114);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory114);
                }
                new Pair(module, singleInstanceFactory114);
                AnonymousClass164 anonymousClass164 = new Function2<Scope, ParametersHolder, AsietTransRegAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.164
                    @Override // kotlin.jvm.functions.Function2
                    public final AsietTransRegAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AsietTransRegAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory115 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AsietTransRegAdapter.class), null, anonymousClass164, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory115);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory115);
                }
                new Pair(module, singleInstanceFactory115);
                AnonymousClass165 anonymousClass165 = new Function2<Scope, ParametersHolder, NewQuizAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.165
                    @Override // kotlin.jvm.functions.Function2
                    public final NewQuizAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new NewQuizAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory116 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NewQuizAdapter.class), null, anonymousClass165, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory116);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory116);
                }
                new Pair(module, singleInstanceFactory116);
                AnonymousClass166 anonymousClass166 = new Function2<Scope, ParametersHolder, SurveyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.166
                    @Override // kotlin.jvm.functions.Function2
                    public final SurveyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SurveyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory117 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SurveyAdapter.class), null, anonymousClass166, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory117);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory117);
                }
                new Pair(module, singleInstanceFactory117);
                AnonymousClass167 anonymousClass167 = new Function2<Scope, ParametersHolder, TeacherSurveyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.167
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherSurveyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherSurveyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory118 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherSurveyAdapter.class), null, anonymousClass167, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory118);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory118);
                }
                new Pair(module, singleInstanceFactory118);
                AnonymousClass168 anonymousClass168 = new Function2<Scope, ParametersHolder, TeacherSurveyQuestionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.168
                    @Override // kotlin.jvm.functions.Function2
                    public final TeacherSurveyQuestionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TeacherSurveyQuestionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory119 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TeacherSurveyQuestionAdapter.class), null, anonymousClass168, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory119);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory119);
                }
                new Pair(module, singleInstanceFactory119);
                AnonymousClass169 anonymousClass169 = new Function2<Scope, ParametersHolder, QuizDescriptiveResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.169
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizDescriptiveResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizDescriptiveResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory120 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizDescriptiveResultAdapter.class), null, anonymousClass169, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory120);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory120);
                }
                new Pair(module, singleInstanceFactory120);
                AnonymousClass170 anonymousClass170 = new Function2<Scope, ParametersHolder, QuizMultipleResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.170
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizMultipleResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizMultipleResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory121 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizMultipleResultAdapter.class), null, anonymousClass170, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory121);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory121);
                }
                new Pair(module, singleInstanceFactory121);
                AnonymousClass171 anonymousClass171 = new Function2<Scope, ParametersHolder, QuizUploadResultAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.171
                    @Override // kotlin.jvm.functions.Function2
                    public final QuizUploadResultAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new QuizUploadResultAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory122 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(QuizUploadResultAdapter.class), null, anonymousClass171, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory122);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory122);
                }
                new Pair(module, singleInstanceFactory122);
                AnonymousClass172 anonymousClass172 = new Function2<Scope, ParametersHolder, CourseEvaluationSurveyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.172
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseEvaluationSurveyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseEvaluationSurveyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory123 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseEvaluationSurveyAdapter.class), null, anonymousClass172, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory123);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory123);
                }
                new Pair(module, singleInstanceFactory123);
                AnonymousClass173 anonymousClass173 = new Function2<Scope, ParametersHolder, CourseSurveySubjectsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.173
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseSurveySubjectsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseSurveySubjectsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory124 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseSurveySubjectsAdapter.class), null, anonymousClass173, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory124);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory124);
                }
                new Pair(module, singleInstanceFactory124);
                AnonymousClass174 anonymousClass174 = new Function2<Scope, ParametersHolder, CourseSurveyQuestionsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.174
                    @Override // kotlin.jvm.functions.Function2
                    public final CourseSurveyQuestionsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new CourseSurveyQuestionsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory125 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CourseSurveyQuestionsAdapter.class), null, anonymousClass174, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory125);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory125);
                }
                new Pair(module, singleInstanceFactory125);
                AnonymousClass175 anonymousClass175 = new Function2<Scope, ParametersHolder, POSurveyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.175
                    @Override // kotlin.jvm.functions.Function2
                    public final POSurveyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new POSurveyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory126 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(POSurveyAdapter.class), null, anonymousClass175, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory126);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory126);
                }
                new Pair(module, singleInstanceFactory126);
                AnonymousClass176 anonymousClass176 = new Function2<Scope, ParametersHolder, POSurveyQuestionsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.176
                    @Override // kotlin.jvm.functions.Function2
                    public final POSurveyQuestionsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new POSurveyQuestionsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory127 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(POSurveyQuestionsAdapter.class), null, anonymousClass176, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory127);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory127);
                }
                new Pair(module, singleInstanceFactory127);
                AnonymousClass177 anonymousClass177 = new Function2<Scope, ParametersHolder, GraduateExitSurveyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.177
                    @Override // kotlin.jvm.functions.Function2
                    public final GraduateExitSurveyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GraduateExitSurveyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory128 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GraduateExitSurveyAdapter.class), null, anonymousClass177, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory128);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory128);
                }
                new Pair(module, singleInstanceFactory128);
                AnonymousClass178 anonymousClass178 = new Function2<Scope, ParametersHolder, GraduateSurveyQuestionsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.178
                    @Override // kotlin.jvm.functions.Function2
                    public final GraduateSurveyQuestionsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GraduateSurveyQuestionsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory129 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GraduateSurveyQuestionsAdapter.class), null, anonymousClass178, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory129);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory129);
                }
                new Pair(module, singleInstanceFactory129);
                AnonymousClass179 anonymousClass179 = new Function2<Scope, ParametersHolder, AttendanceCalendarViewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.179
                    @Override // kotlin.jvm.functions.Function2
                    public final AttendanceCalendarViewAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AttendanceCalendarViewAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory130 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AttendanceCalendarViewAdapter.class), null, anonymousClass179, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory130);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory130);
                }
                new Pair(module, singleInstanceFactory130);
                AnonymousClass180 anonymousClass180 = new Function2<Scope, ParametersHolder, StationaryMainAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.180
                    @Override // kotlin.jvm.functions.Function2
                    public final StationaryMainAdapter invoke(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.checkNotNullParameter(factory, "$this$factory");
                        Intrinsics.checkNotNullParameter(parametersHolder, "<name for destructuring parameter 0>");
                        return new StationaryMainAdapter((FragmentManager) parametersHolder.elementAt(0, Reflection.getOrCreateKotlinClass(FragmentManager.class)));
                    }
                };
                FactoryInstanceFactory factoryInstanceFactory50 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StationaryMainAdapter.class), null, anonymousClass180, Kind.Factory, CollectionsKt.emptyList()));
                module.indexPrimaryType(factoryInstanceFactory50);
                new Pair(module, factoryInstanceFactory50);
                AnonymousClass181 anonymousClass181 = new Function2<Scope, ParametersHolder, BookingAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.181
                    @Override // kotlin.jvm.functions.Function2
                    public final BookingAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookingAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory131 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookingAdapter.class), null, anonymousClass181, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory131);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory131);
                }
                new Pair(module, singleInstanceFactory131);
                AnonymousClass182 anonymousClass182 = new Function2<Scope, ParametersHolder, BookingHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.182
                    @Override // kotlin.jvm.functions.Function2
                    public final BookingHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new BookingHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory132 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BookingHistoryAdapter.class), null, anonymousClass182, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory132);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory132);
                }
                new Pair(module, singleInstanceFactory132);
                AnonymousClass183 anonymousClass183 = new Function2<Scope, ParametersHolder, HostelNewMonthlyAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.183
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewMonthlyAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewMonthlyAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory133 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewMonthlyAdapter.class), null, anonymousClass183, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory133);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory133);
                }
                new Pair(module, singleInstanceFactory133);
                AnonymousClass184 anonymousClass184 = new Function2<Scope, ParametersHolder, HostelNewAdmissionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.184
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewAdmissionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewAdmissionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory134 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewAdmissionAdapter.class), null, anonymousClass184, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory134);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory134);
                }
                new Pair(module, singleInstanceFactory134);
                AnonymousClass185 anonymousClass185 = new Function2<Scope, ParametersHolder, HostelNewReceiptAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.185
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewReceiptAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewReceiptAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory135 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewReceiptAdapter.class), null, anonymousClass185, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory135);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory135);
                }
                new Pair(module, singleInstanceFactory135);
                AnonymousClass186 anonymousClass186 = new Function2<Scope, ParametersHolder, HostelNewDetailsAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.186
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewDetailsAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewDetailsAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory136 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewDetailsAdapter.class), null, anonymousClass186, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory136);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory136);
                }
                new Pair(module, singleInstanceFactory136);
                AnonymousClass187 anonymousClass187 = new Function2<Scope, ParametersHolder, HostelNewHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.187
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory137 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewHistoryAdapter.class), null, anonymousClass187, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory137);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory137);
                }
                new Pair(module, singleInstanceFactory137);
                AnonymousClass188 anonymousClass188 = new Function2<Scope, ParametersHolder, HostelNewHistory2Adapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.188
                    @Override // kotlin.jvm.functions.Function2
                    public final HostelNewHistory2Adapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new HostelNewHistory2Adapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory138 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HostelNewHistory2Adapter.class), null, anonymousClass188, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory138);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory138);
                }
                new Pair(module, singleInstanceFactory138);
                AnonymousClass189 anonymousClass189 = new Function2<Scope, ParametersHolder, SubjectRegistrationAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.189
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRegistrationAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectRegistrationAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory139 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRegistrationAdapter.class), null, anonymousClass189, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory139);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory139);
                }
                new Pair(module, singleInstanceFactory139);
                AnonymousClass190 anonymousClass190 = new Function2<Scope, ParametersHolder, TransportHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.190
                    @Override // kotlin.jvm.functions.Function2
                    public final TransportHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TransportHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory140 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransportHistoryAdapter.class), null, anonymousClass190, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory140);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory140);
                }
                new Pair(module, singleInstanceFactory140);
                AnonymousClass191 anonymousClass191 = new Function2<Scope, ParametersHolder, PoSurveyQuestionsNewAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.191
                    @Override // kotlin.jvm.functions.Function2
                    public final PoSurveyQuestionsNewAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new PoSurveyQuestionsNewAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory141 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PoSurveyQuestionsNewAdapter.class), null, anonymousClass191, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory141);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory141);
                }
                new Pair(module, singleInstanceFactory141);
                AnonymousClass192 anonymousClass192 = new Function2<Scope, ParametersHolder, ApplyPreferenceSubRegAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.192
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyPreferenceSubRegAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyPreferenceSubRegAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory142 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegAdapter.class), null, anonymousClass192, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory142);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory142);
                }
                new Pair(module, singleInstanceFactory142);
                AnonymousClass193 anonymousClass193 = new Function2<Scope, ParametersHolder, ApplyPreferenceSubRegQuestionAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.193
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyPreferenceSubRegQuestionAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyPreferenceSubRegQuestionAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory143 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegQuestionAdapter.class), null, anonymousClass193, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory143);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory143);
                }
                new Pair(module, singleInstanceFactory143);
                AnonymousClass194 anonymousClass194 = new Function2<Scope, ParametersHolder, ApplyPreferenceSubRegSemQndAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.194
                    @Override // kotlin.jvm.functions.Function2
                    public final ApplyPreferenceSubRegSemQndAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ApplyPreferenceSubRegSemQndAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory144 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApplyPreferenceSubRegSemQndAdapter.class), null, anonymousClass194, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory144);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory144);
                }
                new Pair(module, singleInstanceFactory144);
                AnonymousClass195 anonymousClass195 = new Function2<Scope, ParametersHolder, SubjectRegStatusAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.195
                    @Override // kotlin.jvm.functions.Function2
                    public final SubjectRegStatusAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new SubjectRegStatusAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory145 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SubjectRegStatusAdapter.class), null, anonymousClass195, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory145);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory145);
                }
                new Pair(module, singleInstanceFactory145);
                AnonymousClass196 anonymousClass196 = new Function2<Scope, ParametersHolder, ViewSubjectRegistrationAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.196
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewSubjectRegistrationAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewSubjectRegistrationAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory146 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewSubjectRegistrationAdapter.class), null, anonymousClass196, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory146);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory146);
                }
                new Pair(module, singleInstanceFactory146);
                AnonymousClass197 anonymousClass197 = new Function2<Scope, ParametersHolder, ViewSemSubHistoryAdapter>() { // from class: in.etuwa.app.di.ModulesKt$AdapterModule$1.197
                    @Override // kotlin.jvm.functions.Function2
                    public final ViewSemSubHistoryAdapter invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new ViewSemSubHistoryAdapter();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory147 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ViewSemSubHistoryAdapter.class), null, anonymousClass197, Kind.Singleton, CollectionsKt.emptyList()));
                module.indexPrimaryType(singleInstanceFactory147);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory147);
                }
                new Pair(module, singleInstanceFactory147);
            }
        }, 1, null);
        AdapterModule = module$default5;
        appModules = CollectionsKt.listOf((Object[]) new Module[]{module$default, module$default2, module$default3, module$default4, module$default5});
    }

    public static final Module getDataModule() {
        return DataModule;
    }

    public static final Module getNetworkModule() {
        return NetworkModule;
    }

    public static final Module getFactoryModule() {
        return FactoryModule;
    }

    public static final Module getViewModelModule() {
        return ViewModelModule;
    }

    public static final Module getAdapterModule() {
        return AdapterModule;
    }

    public static final List<Module> getAppModules() {
        return appModules;
    }
}