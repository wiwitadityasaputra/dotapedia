describe('main navigation', () => {
	it('should change theh url', () => {
		cy.visit('/home');

		cy.get('.dp-nav-tournament').click();
		cy.url().should('include', '/tournament');

		cy.get('.dp-nav-team').click();
		cy.url().should('include', '/team');

		cy.get('.dp-nav-player').click();
		cy.url().should('include', '/player');

		cy.get('.dp-nav-hero').click();
		cy.url().should('include', '/hero');

		cy.get('.dp-nav-schedule').click();
		cy.url().should('include', '/schedule');

		cy.get('.dp-nav-news').click();
		cy.url().should('include', '/news');

		cy.get('.dp-nav-home').click();
		cy.url().should('include', '/home');
	})
})