describe('team page', () => {

	function toTeamPage() {
		cy.visit('/team');
	}

	it('should open team page', () => {
		toTeamPage();
		cy.contains('Top Tier');
		cy.contains('Teams');
	})

	it('should have some regions', () => {
		cy.get('.dp-region-btn').should('have.length', 6);
	})

	it('should have some teams', () => {
		cy.get('.dp-team').should('have.length.greaterThan', 1);
	})

	it('each team should have players', () => {
		cy.get('.dp-team').each(($el) => {
			cy.wrap($el).find('.dp-player-link').should('have.length.greaterThan', 1);
		})
	})

	describe('region change', () => {

		let currentTeam = '';

		it('should change the first team-name', () => {
			cy.get('.dp-team-name').invoke('text').then((text) => {
				currentTeam = text;

				cy.get('.dp-region-btn').last().click();

				cy.get('.dp-team-name').invoke('text').then((text) => {
					assert.notEqual(currentTeam, text);
				});
			})
		})

	})

	describe('navigation', () => {

		beforeEach(() => {
			toTeamPage();
		})

		it('team-name click, should goto team-detail page', () => {
			cy.get('.dp-team-name').first().click();
			cy.contains('Team Detail');
		})

		it('team-logo click, should goto team-detail page', () => {
			cy.get('.dp-team-logo').first().click();
			cy.contains('Team Detail');
		})

		it('should goto player-detail page', () => {
			cy.get('.dp-player-link').first().click();
			cy.contains('Player');
			cy.contains('Biography');
		})

	})

})