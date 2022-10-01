describe('hero page', () => {

	let allHeroes;
	let strengthHeroes;
	let agilityHeroes;
	let intelegenceHeroes;

	function toHeroPage() {
		cy.visit('/hero');
	}

	it('should open hero page', () => {
		toHeroPage();
		cy.contains('DoTA2');
		cy.contains('Heroes');

		cy.get('.dp-hero-name').invoke('text').then((text) => {
			allHeroes += text;
		})
	})

	it('should show agility heroes', () => {
		cy.get('.dp-btn-agility').first().click();

		cy.get('.dp-hero-name').invoke('text').then((text) => {
			agilityHeroes += text;

			assert.notEqual(allHeroes, agilityHeroes);
		})
	})

	it('should show strength heroes', () => {
		cy.get('.dp-btn-strength').first().click();

		cy.get('.dp-hero-name').invoke('text').then((text) => {
			strengthHeroes += text;

			assert.notEqual(allHeroes, strengthHeroes);
			assert.notEqual(agilityHeroes, strengthHeroes);
		})
	})

	it('should show intelligence heroes', () => {
		cy.get('.dp-btn-intelligence').first().click();

		cy.get('.dp-hero-name').invoke('text').then((text) => {
			intelegenceHeroes += text;

			assert.notEqual(allHeroes, intelegenceHeroes);
			assert.notEqual(agilityHeroes, intelegenceHeroes);
			assert.notEqual(strengthHeroes, intelegenceHeroes);
		})
	})

});