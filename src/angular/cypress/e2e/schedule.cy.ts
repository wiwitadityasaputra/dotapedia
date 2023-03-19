describe('schedule page', () => {

	function toSchedulePage() {
		cy.visit('/schedule');
	}

	it('should open schedule page', () => {
		toSchedulePage();
		cy.contains('Upcoming');
		cy.contains('Match');
	})

	it('should have some upcoming matches', () => {
		cy.get('.dp-upcoming-match').should('have.length.greaterThan', 1);
	})

	it('should have some latest matches', () => {
		cy.get('.dp-latest-match').should('have.length.greaterThan', 1);
	})

	describe('navigation', () => {

		beforeEach(() => {
			toSchedulePage();
		})

		it('upcoming-match team-a click, should goto team-detail page', () => {
			cy.get('.dp-um-team-a').first().click();
			cy.contains('Team Detail');
		})

		it('upcoming-match team-b click, should goto team-detail page', () => {
			cy.get('.dp-um-team-b').first().click();
			cy.contains('Team Detail');
		})

		it('upcoming-match tournament click, should goto tournament-detail page', () => {
			cy.get('.dp-up-tournament').first().click();
			cy.contains('Tournament Detail');
			cy.contains('Teams Participant');
		})

		it('latest-match team-a click, should goto team-detail page', () => {
			cy.get('.dp-lm-team-a').first().click();
			cy.contains('Team Detail');
		})

		it('latest-match team-b click, should goto team-detail page', () => {
			cy.get('.dp-lm-team-b').first().click();
			cy.contains('Team Detail');
		})

		it('latest-match tournament click, should goto tournament-detail page', () => {
			cy.get('.dp-lm-tournament').first().click();
			cy.contains('Tournament Detail');
			cy.contains('Teams Participant');
		})

	})

});