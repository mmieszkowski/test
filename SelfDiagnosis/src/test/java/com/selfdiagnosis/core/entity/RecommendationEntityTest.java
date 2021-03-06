package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link RecommendationEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class RecommendationEntityTest extends EntityTest {

    /**
     * Checks recommendation with blank name.
     */
    @Test
    public void nameIsBlank() {
        RecommendationEntity recommendation = createValidEntity();
        recommendation.setRecommendation("");
        Set<ConstraintViolation<RecommendationEntity>> constraintViolations = getValidator().validate(recommendation);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.recommendation}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks recommendation with too long text.
     */
    @Test
    public void recommendationIsTooLong() {
        RecommendationEntity recommendation = createValidEntity();
        String text = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.RECOMMENDATION_LENGTH_MAX + 1);
        recommendation.setRecommendation(text);
        Set<ConstraintViolation<RecommendationEntity>> constraintViolations = getValidator().validate(recommendation);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Length.recommendation}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected RecommendationEntity createValidEntity() {
        return createValidRecommendationEntity();
    }

    /**
     * Creates valid recommendation entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link RecommendationEntity} 
     */
    public static RecommendationEntity createValidRecommendationEntity() {
        RecommendationEntity recommendation = new RecommendationEntity();
        recommendation.setRecommendation("Do not eat before the test.");
        return recommendation;
    }
    
    @Override
    protected RecommendationEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveRecommendationEntity(entity, adminService);
    }

    /**
     * Saves recommendation.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static RecommendationEntity saveRecommendationEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (RecommendationEntity) adminService.saveEntity(entity);
    }
    
}
