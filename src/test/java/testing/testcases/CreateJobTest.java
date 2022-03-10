package testing.testcases;

import models.JobAllocationModel;
import models.JobDetailsModel;
import org.testng.annotations.Test;
import pages.Header;
import testing.testng.TestFrame;

public class CreateJobTest extends BaseTest {

    @Test
    public void createScheduleJob() {
        JobDetailsModel job = new JobDetailsModel();
        JobAllocationModel allocation = new JobAllocationModel();
        new TestFrame("001") {
            @Override
            public void steps() {
                new Header(driver).searchValidContact("Jenny John Dow")
                        .clickOnScheduleJobButton()
                        .createScheduleJobFields(job)
                        .clickOnAllocateResourceButton()
                        .updateAllocatedResource(allocation.getResource())
                        .goToPersonalContactPage();
                new Header(driver).clickOnJobTab().openNewestJob()
                        .verifyJobDetails(job)
                        .clickOnRelatedTab()
                        .openJobAllocationDetails().verifyJobAllocationDetails(allocation);


            }
        }.run();
    }


}
