describe('tournament page', () => {

	function toTournamentPage() {
		cy.visit('/tournament');
	}

	it('should open tournament page', () => {
		toTournamentPage();
		cy.contains('DoTa2');
		cy.contains('Tournaments');
	})

	it('should have some regions', () => {
		cy.get('.dp-region').should('have.length', 6);
	})

	it('should have some tournaments', () => {
		cy.get('.dp-tournament').should('have.length.greaterThan', 1);
	})

	it('all-region should checked', () => {
		cy.get('.dp-region-checkbox-allregion').first().invoke('attr', 'ng-reflect-model').should('eq', 'true');
	})

	it('others-region should unchecked', () => {
		cy.get('.dp-region-checkbox').each(($el) => {
			cy.wrap($el).invoke('attr', 'ng-reflect-model').should('eq', 'false');
		})
	})

	describe('region change', () => {

		let totalTournament = 0;

		it('uncheck all-region should empty tournaments', () => {
			cy.get('.dp-tournament').then(($el) => {
				totalTournament = Cypress.$($el).length;

				cy.get('.dp-checkbox-container').first().click();
				cy.get('.dp-tournament').should('have.length', 0);
			})
		})

		it('check any-region should has tournaments with different size', () => {
			cy.get('.dp-checkbox-container').last().click();
			cy.get('.dp-tournament').then(($el) => {
				assert.notEqual(totalTournament, Cypress.$($el).length);
			});
		})
	})

	describe('navigation', () => {

		beforeEach(() => {
			toTournamentPage();
		})

		it('should goto tournament-detail page', () => {
			cy.get('.dp-image-box').first().click();
			cy.contains('Tournament Detail');
			cy.contains('Teams Participant');
		})

	})


})